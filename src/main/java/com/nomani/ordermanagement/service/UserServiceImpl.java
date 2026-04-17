package com.nomani.ordermanagement.service;

import com.nomani.ordermanagement.dao.UserRepository;
import com.nomani.ordermanagement.dto.UserDto;
import com.nomani.ordermanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDto createUser(User user) {
        if(!validateUser(user)) {
            throw new RuntimeException(("Invalid user details"));
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        return null;
    }

    private boolean validateUser(User user) {
        if(user.getEmail() == null) {
            return false;
        }
        if(user.getName() == null || user.getEmail().isEmpty()) {
            return false;
        }
        if(user.getRole() == null || user.getRole().isEmpty()) {
            return false;
        }
        return true;
    }
}
