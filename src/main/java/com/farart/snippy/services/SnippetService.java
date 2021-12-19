package com.farart.snippy.services;

import com.farart.snippy.entities.Snippet;
import com.farart.snippy.exceptions.SnippetNotFoundException;
import com.farart.snippy.repositories.SnippetsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SnippetService {

    private final SnippetsRepository repository;

    public List<Snippet> getAllSnippets() {
        return repository.findAll();
    }

    public void editSnippet(Long snippetId, Snippet snippet) {
        Optional<Snippet> retrieved = repository.findById(snippetId);
        // TODO implement copy in snippet and edit this method accordingly
        if (!retrieved.isPresent()) {
            throw new SnippetNotFoundException("Such snippet not found");
        }
        Snippet toEdit = retrieved.get();
        repository.save(toEdit);
    }
}