package com.farart.snippy.controllers;

import com.farart.snippy.exceptions.EntityExistException;
import com.farart.snippy.exceptions.UserNotFoundException;
import com.farart.snippy.models.UserRegisterModel;
import com.farart.snippy.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsersController {
    private final UserService service;

    /**
     * create new user and return public user identifier as string
     *
     * @param userModel required fields to create new user
     * @return String userId
     * @throws EntityExistException email must be unique, otherwise throw exception
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String registerNewUser(@RequestBody UserRegisterModel userModel) throws EntityExistException {
        return service.registerNewUser(userModel);
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestHeader("email") String email, @RequestHeader("password") String password) throws UserNotFoundException {
        return new ResponseEntity<>(service.login(email, password), HttpStatus.OK);
    }
}
