package com.partenupreview.partenup.service;

import com.partenupreview.partenup.dto.OurUser;
import com.partenupreview.partenup.entities.UserDb;
import com.partenupreview.partenup.repository.UserDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {


     @Autowired
     private UserDbRepository userDbRepository;



     public boolean saveUser(OurUser user){
         UserDb daSalvare = OurUser.fromOurUser(user);
         try{
             userDbRepository.save(daSalvare);
             return true;
         }catch(Exception e){
             e.printStackTrace();
             return false;
         }
     }



     public boolean login(OurUser user){
         try{
             UserDb dbuser = userDbRepository.findByUsername(user.getUsername());
             
             if(dbuser.getPassword().equals(user.getPassword())){

                 return true;
             }

             return false;
         }catch(Exception e){
             e.printStackTrace();
             return false;
         }
     }



     public List<UserDb> findAllUser(){
         return userDbRepository.findAll();
     }



     public List<UserDb> findAllByUserNameContains(String filter){
         return userDbRepository.findAllByUsernameContains(filter);
     }



    public List<OurUser> filterUser(List<OurUser> userList, String filter){
        List<OurUser> result = new LinkedList<>();
        userList.forEach((user) -> {
            if(user.getUsername().equalsIgnoreCase(filter)){
                result.add(user);
            }
        });
        return result;
    }


    public boolean ciao(){
        return true;
    }







}
