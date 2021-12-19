package com.farart.snippy.tests;

import com.farart.snippy.entities.ComplementaryField;
import com.farart.snippy.entities.Snippet;
import com.farart.snippy.repositories.SnippetsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//@Component
@RequiredArgsConstructor
public class TestSnippetDeepCopy implements CommandLineRunner {

    private final SnippetsRepository snippetsRepository;

    @Override
    public void run(String... args) {
        ComplementaryField field1 = new ComplementaryField();
        field1.setSnippet(new Snippet());
        field1.setContent("Content");
        field1.setMapKey("key1");

        ComplementaryField field2 = field1.clone();
        field2.setMapKey("key2");

        System.out.println("Field1: " + field1);
        System.out.println("Field2: " + field2);
        System.out.println("Field1==Field2? " + (field1.getSnippet() == field2.getSnippet()));
    }

    /**
     * test deep copy of entities
     */
    private void testEntitiesDeepCopy() {

    }
}
