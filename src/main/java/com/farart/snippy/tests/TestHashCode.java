package com.farart.snippy.tests;

import com.farart.snippy.entities.User;
import org.springframework.boot.CommandLineRunner;

//@Component
public class TestHashCode implements CommandLineRunner {
    @Override
    public void run(String... args) {
        User user = new User();
        user.setId(2);
        user.setEmail("aaa@aaa.com");
        System.out.println(user.hashCode());
    }
}
