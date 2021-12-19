package com.farart.snippy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SnippyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnippyApplication.class, args);
		System.out.println("Application started successfully");
	}

}
