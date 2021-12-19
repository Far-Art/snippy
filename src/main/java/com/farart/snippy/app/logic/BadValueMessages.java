package com.farart.snippy.app.logic;

public class BadValueMessages {
    public static final String PASSWORD_MIN_LENGTH = String.format("Password must include at least %s characters", FieldValues.PASSWORD_MIN_LENGTH);
    public static final String PASSWORD_MAX_LENGTH = String.format("Password cannot exceed %s characters", FieldValues.PASSWORD_MAX_LENGTH);

    public static final String FIRST_NAME_MAX_LENGTH = String.format("First name cannot exceed %s characters", FieldValues.FIRST_NAME_MAX_LENGTH);
    public static final String LAST_NAME_MAX_LENGTH = String.format("Last name cannot exceed %s characters", FieldValues.LAST_NAME_MAX_LENGTH);

}
