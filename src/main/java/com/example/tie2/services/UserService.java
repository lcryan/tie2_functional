package com.example.tie2.services;

import com.example.tie2.dtos.UserDto;
import com.example.tie2.exceptions.UsernameNotFoundException;
import com.example.tie2.models.Authority;
import com.example.tie2.models.User;
import com.example.tie2.repositories.UserRepository;
import com.example.tie2.utils.RandomStringGenerator;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // --- GETTING LIST OF USERS --- //
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtoList = new ArrayList<>();
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
            UserDto userDto = userToUserDto(user);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    // --- CREATING NEW USER --- //
    public String createNewUser(UserDto userDto) {
        String randomString = RandomStringGenerator.generateString(33);
        userDto.setApikey(randomString);
        User newUser = userRepository.save(userDtotoUser(userDto));
        return newUser.getUsername();
    } // missing password encoding! //

    // --- getting a user by username --- //
    public UserDto getUser(String username) {
        Optional<User> optionalUser = userRepository.findById(Long.valueOf(username)); // long.valueOf method converts username into a Long value - which we need for user id //TODO: check if functional //
        if (optionalUser.isPresent()) {
            return userToUserDto(optionalUser.get());
        } else {
            throw new UsernameNotFoundException(username);
        }
    }

    // --- checking, if user actually exists --- //
    public boolean userExists(String username) {
        return userRepository.existsById(Long.valueOf(username));
    }

    // --- UPDATING USER --- //
    public void updateUser(String username, UserDto newUser) {
        if (userRepository.existsById(Long.valueOf(username))) {
            User user = userRepository.findById(Long.valueOf(username)).get();

            user.setUsername(newUser.getUsername());
            user.setPassword(newUser.getPassword());
            user.setFirstname(newUser.getFirstname());
            user.setLastname(newUser.getLastname());
            user.setEmail(newUser.getEmail());
            userRepository.save(user);

        } else {
            throw new UsernameNotFoundException(username);
        }
    }

    // --- DELETE USER --- //
    public void deleteUser(String username) {
        userRepository.deleteById(Long.valueOf(username));
    }

    // --- ADDING AUTHORITY to USER -- //
    public void addAuthority(String username, String authority) {
        if (userRepository.existsById(Long.valueOf(username))) {
            User user = userRepository.findById(Long.valueOf(username)).get();
            user.addAuthority(new Authority(username, authority));
            userRepository.save(user);
        } else {
            throw new UsernameNotFoundException(username);
        }
    }

    public void removeAuthority(String username, String authority) {
        if (userRepository.existsById(Long.valueOf(username))) {
            User user = userRepository.findById(Long.valueOf(username)).get();
            Authority toRemoveAuth = user.getAuthoritySet().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
            user.removeAuthority(toRemoveAuth);
            userRepository.save(user);
        } else {
            throw new UsernameNotFoundException(username);
        }
    }


    // TRANSFER METHODS for User - model - dto -  model --- decided to go without the input dto - as it is the same as the user dto //

    public UserDto userToUserDto(User user) {

        var userDto = new UserDto();

        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setFirstname(user.getFirstname());
        userDto.setLastname(user.getLastname());
        userDto.setEmail(user.getEmail());
        userDto.setEnabled(user.isEnabled());
        userDto.setAuthoritySet(user.getAuthoritySet());
        userDto.setApikey(user.getApikey());

        return userDto;
    }

    public User userDtotoUser(UserDto userDto) {
        var user = new User();

        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        user.setEnabled(userDto.getEnabled());
        user.setApikey(userDto.getApikey());

        return user;
    }
}


// TODO  Zorg dat in de createUser methode het password encode wordt, zodat een nieuwe gebruiker ook kan inloggen.//