package com.farart.snippy.entities;

import com.farart.snippy.beans.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.farart.snippy.app.logic.FieldValues;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @JsonIgnore
    private long id;

    @Column(nullable = false)
    private String userId;

    @Size(max = FieldValues.FIRST_NAME_MAX_LENGTH)
    private String firstName;

    @Size(max = FieldValues.LAST_NAME_MAX_LENGTH)
    private String lastName;

    @Column(nullable = false, unique = true, length = 200)
    private String email;

    @Column(nullable = false)
    @Size(min = FieldValues.PASSWORD_MIN_LENGTH, max = FieldValues.PASSWORD_MAX_LENGTH)
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    @Column(nullable = false, updatable = false)
    private Instant created = Instant.now();

    private Instant updated = Instant.now();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Snippet> snippets = new ArrayList<>();
}
