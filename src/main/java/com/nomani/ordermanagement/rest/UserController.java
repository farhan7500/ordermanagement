package com.nomani.ordermanagement.rest;

import com.nomani.ordermanagement.dto.RegisterUserRequest;
import com.nomani.ordermanagement.dto.RegisterUserResponse;
import com.nomani.ordermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/auth")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public RegisterUserResponse signup(@RequestBody RegisterUserRequest user) {
        System.out.println(user);
        return userService.registerUser(user);
    }
}
