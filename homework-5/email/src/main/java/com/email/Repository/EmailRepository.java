package com.email.Repository;

import com.email.Model.Email;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EmailRepository extends JpaRepository<Email,Integer> {
}
