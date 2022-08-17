package com.partenupreview.partenup.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {


    List<User> findAllByUsernameContains(String username);


    List<User> findAllByUsername(String username);


    Optional<User> findByUsername(String username);


    List<User> findAllByUsernameAndPassword(String username, String password);

}
