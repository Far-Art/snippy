package com.farart.snippy.security;

import com.farart.snippy.entities.User;
import com.farart.snippy.exceptions.UserNotFoundException;
import com.farart.snippy.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginManager {

    private final UsersRepository repository;

    public String login(String email, String password) throws UserNotFoundException {
        if (!repository.existsByEmailAndPassword(email, password)) {
            throw new UserNotFoundException("Email or Password incorrect");
        }
        return repository.findByEmailAndPassword(email, password).getUserId();
    }
}
