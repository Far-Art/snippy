package com.farart.snippy.repositories;

import com.farart.snippy.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
    boolean existsByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);

    User findByEmailAndPassword(String email, String password);
}
