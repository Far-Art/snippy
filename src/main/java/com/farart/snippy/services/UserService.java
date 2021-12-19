package com.farart.snippy.services;

import com.farart.snippy.entities.User;
import com.farart.snippy.exceptions.EntityExistException;
import com.farart.snippy.exceptions.UserNotFoundException;
import com.farart.snippy.models.UserRegisterModel;
import com.farart.snippy.security.LoginManager;
import com.farart.snippy.security.RegisterManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final RegisterManager registerManager;
    private final LoginManager loginManager;

    public String registerNewUser(UserRegisterModel userModel) throws EntityExistException {
        return registerManager.registerNewUser(userModel);
    }

    public String login(String email, String password) throws UserNotFoundException {
        return loginManager.login(email, password);
    }
}
