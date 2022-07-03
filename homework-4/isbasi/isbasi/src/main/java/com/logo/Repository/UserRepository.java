package com.logo.Repository;

import com.logo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);

    List<User> findByEmailAndName(String email, String name);

    List<User> findByEmailAndNameAndAddress_Country(String email, String name, String country);

    @Query(value = "Select * from User where name=?", nativeQuery = true)
    List<User> findByEmailAndName(String email, String name, String string);
}
