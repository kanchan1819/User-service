package com.UserAuthentication.service;

import com.UserAuthentication.dto.UserDto;
import com.UserAuthentication.entity.User;

import java.util.List;

import org.springframework.stereotype.Service;


public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
