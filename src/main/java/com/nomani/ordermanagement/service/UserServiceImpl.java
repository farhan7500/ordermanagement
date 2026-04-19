package com.nomani.ordermanagement.service;

import com.nomani.ordermanagement.dao.AuthorityRepository;
import com.nomani.ordermanagement.dao.UserRepository;
import com.nomani.ordermanagement.dto.RegisterUserRequest;
import com.nomani.ordermanagement.dto.RegisterUserResponse;
import com.nomani.ordermanagement.dto.UserDto;
import com.nomani.ordermanagement.entity.Authority;
import com.nomani.ordermanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }


    @Override
    @Transactional
    public RegisterUserResponse registerUser(RegisterUserRequest user) {
        if(!validateUser(user)) {
            throw new RuntimeException(("Invalid user details"));
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());

        User userEntity = new User(user.getName(),
                user.getEmail(),
                encodedPassword,
                1);

        userRepository.save(userEntity);

        for(String role: user.getRoles()) {
            Authority authority = new Authority(user.getEmail(), "ROLE_" + role);
            authorityRepository.save(authority);
        }
        return new RegisterUserResponse(user.getName(), user.getEmail(), user.getRoles());
    }

    private boolean validateUser(RegisterUserRequest user) {
        if(user.getEmail() == null) {
            return false;
        }
        if(user.getName() == null || user.getEmail().isEmpty()) {
            return false;
        }
        if(user.getRoles() == null || user.getRoles().isEmpty()) {
            return false;
        }
        return true;
    }
}
