package com.partenupreview.partenup.controllers;

import com.partenupreview.partenup.dto.OurUser;
import com.partenupreview.partenup.entities.UserDb;
import com.partenupreview.partenup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("all")
    public List<UserDb> listAllUser(){
        return userService.findAllUser();
    }

    @GetMapping("get/{id}")
    public OurUser getUser(@PathVariable long id){
        //return user by id
        return null;
    }



    @PostMapping("")
    public boolean saveUser(@RequestBody OurUser user){
        return userService.saveUser(user);
    }


    @GetMapping("filter")
    public List<UserDb> findAllByUsernameContains(@PathParam("filter") String filter){
        return userService.findAllByUserNameContains(filter);
    }


    @DeleteMapping("")
    public OurUser deleteUser(@RequestBody OurUser user){
        //Rimuovi utente
        return null;
    }



    @PostMapping("login")
    public boolean login(@RequestBody OurUser user){
         return userService.login(user);
    }

}
