package com.nomani.ordermanagement.service;


import com.nomani.ordermanagement.dto.UserDto;
import com.nomani.ordermanagement.entity.User;

public interface UserService {
    UserDto createUser(User user);
}
