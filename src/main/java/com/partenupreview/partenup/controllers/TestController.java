package com.partenupreview.partenup.controllers;

import com.partenupreview.partenup.dto.OurUser;
import com.partenupreview.partenup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("api1")
@CrossOrigin
public class TestController {


    @Autowired
    private UserService userService;

    // GET MAPPATA SULL'URL /ciao
    @GetMapping("/ciao")
    public List<OurUser> ciao(){
        List<OurUser> listastringhe = new LinkedList<>();
        for(int i = 0; i<10; i++){
            listastringhe.add(new OurUser("USERNAME " + i, "PASSWORD " + i));
        }
       return listastringhe;
    }


    @GetMapping("withpath/{variable}")
    public String withPathVariable(@PathVariable String variable){
        return variable;
    }




    @GetMapping("withparams")
    public String withPathParams(@RequestParam("nome") String nome, @RequestParam("eta") String eta){
        return nome + "      " + eta;
    }


    @PostMapping("insertuser")
    public List<OurUser> insertUser(@RequestBody List<OurUser> userList){
        return userList;
    }





}
