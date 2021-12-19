package com.farart.snippy.tests;

import com.farart.snippy.entities.ComplementaryField;
import com.farart.snippy.entities.Snippet;
import com.farart.snippy.repositories.SnippetsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//@Component
@RequiredArgsConstructor
public class TestConstraints implements CommandLineRunner {

    private final SnippetsRepository snippetsRepository;

    @Override
    public void run(String... args) {
        testCompositeUniqueConstraint();
    }

    /**
     * test if composite unique constraint works as intended
     */
    private void testCompositeUniqueConstraint() {
        Snippet snippet1 = new Snippet();
        Snippet snippet2 = new Snippet();

        Map<String, ComplementaryField> fieldsMap1 = new HashMap<>();
        Map<String, ComplementaryField> fieldsMap2 = new HashMap<>();

        ComplementaryField field1 = new ComplementaryField();
        ComplementaryField field2 = new ComplementaryField();
        ComplementaryField field3 = new ComplementaryField();
        ComplementaryField field4 = new ComplementaryField();

        field1.setContent("first");
        field1.setMapKey("mapKey3");
        field1.setSnippet(snippet1);

        field2.setContent("second");
        field2.setMapKey("mapKey2");
        field2.setSnippet(snippet1);

        field3.setContent("third");
        field3.setMapKey("mapKey3");
        field3.setSnippet(snippet2);

        field4.setContent("fourth");
        field4.setMapKey("mapKey4");
        field4.setSnippet(snippet2);

        fieldsMap1.put("mapKey1", field1);
        fieldsMap1.put("mapKey2", field2);

        fieldsMap2.put("mapKey1", field3);
        fieldsMap2.put("mapKey2", field4);

        snippet1.setComplementaryFields(fieldsMap1);
        snippet1.setAppName("Docker");
        snippet1.setQuickDescription("Remove containers");
        snippet1.setCommandLine("docker containers remove {container-id}");

        snippet2.setComplementaryFields(fieldsMap2);
        snippet2.setAppName("Linux");
        snippet2.setQuickDescription("create folder");
        snippet2.setCommandLine("some random line {name}");

        snippetsRepository.saveAll(Arrays.asList(snippet1, snippet2));

        snippetsRepository.findAll().get(1).getComplementaryFields().forEach((k, v) -> System.out.println(k + " " + v));
    }
}
