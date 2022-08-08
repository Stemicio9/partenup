package com.partenupreview.partenup.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {


    // @todo Check if the user is logged
    @GetMapping("testlogged")
    public boolean testLogged(){
        return true;
    }


}
