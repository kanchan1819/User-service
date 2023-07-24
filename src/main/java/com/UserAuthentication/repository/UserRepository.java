package com.UserAuthentication.repository;

import com.UserAuthentication.entity.Role;
import com.UserAuthentication.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
