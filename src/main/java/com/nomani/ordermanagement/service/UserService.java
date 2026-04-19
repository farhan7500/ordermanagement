package com.nomani.ordermanagement.service;


import com.nomani.ordermanagement.dto.RegisterUserRequest;
import com.nomani.ordermanagement.dto.RegisterUserResponse;
import com.nomani.ordermanagement.dto.UserDto;
import com.nomani.ordermanagement.entity.User;

public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest user);
}
