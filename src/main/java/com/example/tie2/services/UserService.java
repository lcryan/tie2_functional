package com.example.tie2.services;

import com.example.tie2.dtos.UserDto;
import com.example.tie2.models.User;
import com.example.tie2.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : userList) {
            /*UserDto userDto = // */
        }
    }

    // Transfer Methods for User - model - dto - input dto - model //
// TODO : has to be finalized - after setting up UserDto and InputUserDto ! //
    public UserDto userToUserDto(User user) {
        UserDto userDto = new UserDto();

    }


}


// TODO  Zorg dat in de createUser methode het password encode wordt, zodat een nieuwe gebruiker ook kan inloggen.//