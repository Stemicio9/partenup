package com.partenupreview.partenup.user;

import com.partenupreview.partenup.userdb.UserDb;
import com.partenupreview.partenup.userdb.UserDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserService implements UserDetailsService{


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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         // PROVA DI STEFANO
        System.out.println("ESEGUO IL LOAD BY USERNAME");
        return userDbRepository.findByUsername(username);
    }
}
