package com.partenupreview.partenup.controllers;

import com.partenupreview.partenup.jwt.UsernameAndPasswordAuthRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {



    // @todo da utilizzare per avere un token
    @PostMapping("login")
    public boolean login(@RequestBody UsernameAndPasswordAuthRequest request){
        return true;
    }


}
