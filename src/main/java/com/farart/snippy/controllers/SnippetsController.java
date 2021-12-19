package com.farart.snippy.controllers;

import com.farart.snippy.entities.Snippet;
import com.farart.snippy.services.SnippetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/snippets")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SnippetsController {

    private final SnippetService service;

    @GetMapping
    public List<Snippet> getAllSnippets() {
        // TODO remove thread sleep after test
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return service.getAllSnippets();
    }
}
