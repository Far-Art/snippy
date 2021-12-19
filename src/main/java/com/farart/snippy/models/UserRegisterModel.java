package com.farart.snippy.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRegisterModel {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
