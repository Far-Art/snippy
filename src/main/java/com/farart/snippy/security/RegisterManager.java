package com.farart.snippy.security;

import com.farart.snippy.entities.User;
import com.farart.snippy.exceptions.EntityExistException;
import com.farart.snippy.models.UserRegisterModel;
import com.farart.snippy.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.rmi.server.UID;

@Component
@RequiredArgsConstructor
public class RegisterManager {
    private final UsersRepository repository;

    public String registerNewUser(UserRegisterModel userModel) throws EntityExistException {
        if (repository.existsByEmail(userModel.getEmail())) {
            throw new EntityExistException("Such email already taken");
        }
        User user = initNewUser(userModel);
        repository.save(user);
        return user.getUserId();
    }

    public String createUniqueID() {
        return new UID().toString();
    }

    private User initNewUser(UserRegisterModel userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setPassword(userModel.getPassword());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setUserId(createUniqueID());
        return user;
    }

}
