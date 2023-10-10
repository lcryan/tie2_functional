package com.example.tie2.controllers;

import com.example.tie2.dtos.UserDto;
import com.example.tie2.exceptions.BadRequestException;
import com.example.tie2.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@CrossOrigin // connection to CORSConfig ? //
@RestController
@RequestMapping(value = "/users")
// standard path - remember to only add additional path name depending on what you want to call on//
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // --- GETTING UserList --- //
    @GetMapping(value = "")

    public ResponseEntity<List<UserDto>> getUsersList() {
        List<UserDto> userDtoList = userService.getAllUsers();

        return ResponseEntity.ok().build();
    }

    // ---  GETTING one existing user ---  //
    @GetMapping(value = "/{username}")
    public ResponseEntity<UserDto> getUser(@PathVariable("username") String username) {
        UserDto userDto = userService.getUser(username);

        return ResponseEntity.ok().build(); // is this right ??? Not quite sure, if this will be functional //
    }


    // --- CREATING NEW USER --- //
    @PostMapping(value = "")

    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

        String newUserName = userService.createNewUser(userDto);
        //adding authority to user: //
        userService.addAuthority(newUserName, "ROLE_USER");

        // -- ADDING location to user via URI --- //

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/username").buildAndExpand().toUri();

        return ResponseEntity.created(location).build();
    }

    // --- UPDATING USER --- //
    @PutMapping(value = "/{username}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("username") String username, @RequestBody UserDto userDto) {

        UserDto userDto1 = userService.updateUser(username, userDto);

        return ResponseEntity.noContent().build(); // could we also add okay here ??? //
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<Object> deleteUser(@PathVariable("username") String username) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

    // --- SECTION AUTHORITIES TO USER --- //

    @PostMapping(value = "/{username}/authorities")

    public ResponseEntity<Object> addUserAuthority(@PathVariable("username") String username, @RequestBody Map<String, Object> fields) {
        try {
            String authorityName = (String) fields.get("authority");
            userService.addAuthority(username, authorityName);
            return ResponseEntity.noContent().build();
        } catch (Exception exception) {
            throw new BadRequestException();
        }
    }
}
