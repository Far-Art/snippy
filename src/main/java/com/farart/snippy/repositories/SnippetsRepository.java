package com.farart.snippy.repositories;

import com.farart.snippy.entities.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnippetsRepository extends JpaRepository<Snippet, Long> {
}
