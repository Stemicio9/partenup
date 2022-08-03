package com.partenupreview.partenup.repository;

import com.partenupreview.partenup.entities.UserDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserDbRepository extends JpaRepository<UserDb, Long> {


    List<UserDb> findAllByUsernameContains(String username);


    List<UserDb> findAllByUsername(String username);


    UserDb findByUsername(String username);


    List<UserDb> findAllByUsernameAndPassword(String username, String password);

}
