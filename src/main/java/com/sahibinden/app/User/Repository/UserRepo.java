package com.sahibinden.app.User.Repository;

import com.sahibinden.app.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    @Query("select u from User u where u.email = ?1")
    List<User> checkByEmail(String email);

    @Query("select u from User u where u.email = ?1 and u.password = ?2")
    List<User> login(String email, String password);


}
