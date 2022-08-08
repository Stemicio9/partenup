package com.partenupreview.partenup.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jdk.internal.joptsimple.internal.Strings;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenVerifier extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizzatioHeader = request.getHeader("Autorizzazione");
        if (Strings.isNullOrEmpty(authorizzatioHeader) || !authorizzatioHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }

        String token =authorizzatioHeader.replace("Bearer ","");

        try {
            String secretKey = "ciaociaociaociaociaociaociaociaociaociaociaociao";
            Jwt<Header, Claims> claimsJwt = Jwts.parser().setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes())).parseClaimsJwt(token);

            Claims body = claimsJwt.getBody();

            String username = body.getSubject();

            Authentication authentication = new UsernamePasswordAuthenticationToken(username,null);

            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (JwtException e) {
            throw new IllegalStateException("Il token non è valido");
        }
    }
}
