package com.partenupreview.partenup.controllers;

import com.partenupreview.partenup.user.User;
import com.partenupreview.partenup.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("collaborator")
public class   CollaboratorController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/info")
    public User getUserDetails(){

        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return userRepo.findByUsername(username).get();
    }


}

