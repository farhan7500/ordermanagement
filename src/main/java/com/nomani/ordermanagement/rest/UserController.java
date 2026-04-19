package com.nomani.ordermanagement.rest;

import com.nomani.ordermanagement.dto.RegisterUserRequest;
import com.nomani.ordermanagement.dto.RegisterUserResponse;
import com.nomani.ordermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public RegisterUserResponse signup(@RequestBody RegisterUserRequest user) {
        System.out.println(user);
        return userService.registerUser(user);
    }
}
