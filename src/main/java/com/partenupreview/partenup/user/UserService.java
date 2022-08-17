package com.partenupreview.partenup.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService{


     @Autowired
     private UserRepo userRepo;



     public boolean saveUser(OurUser user){
         User daSalvare = OurUser.fromOurUser(user);
         try{
             userRepo.save(daSalvare);
             return true;
         }catch(Exception e){
             e.printStackTrace();
             return false;
         }
     }



     public List<User> findAllUser(){
         return userRepo.findAll();
     }



     public List<User> findAllByUserNameContains(String filter){
         return userRepo.findAllByUsernameContains(filter);
     }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userRes = userRepo.findByUsername(username);
        if(userRes.isPresent())
            throw new UsernameNotFoundException("Could not findUser with username = " + username);
        User user = userRes.get();
        return new org.springframework.security.core.userdetails.User(
                username,
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))); // Sets the role of the found user
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

}
