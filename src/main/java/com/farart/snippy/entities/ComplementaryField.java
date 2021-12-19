package com.farart.snippy.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "fields", uniqueConstraints = {@UniqueConstraint(name = "uniqueMapKeyAndSnippet", columnNames = {"mapKey", "snippet"})})
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ComplementaryField implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(length = 200)
    private String mapKey; // used to retrieve a field from a snippets fieldsMap

    private String content;

    private boolean isOptional = true;

    @ManyToOne
    @JoinColumn(name = "snippet")
    @JsonBackReference
    @ToString.Exclude
    private Snippet snippet;

    @Override
    public ComplementaryField clone() {
        try {
            ComplementaryField clone = (ComplementaryField) super.clone();

            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
