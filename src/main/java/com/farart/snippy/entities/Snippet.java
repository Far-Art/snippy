package com.farart.snippy.entities;

import com.farart.snippy.beans.IconsPath;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "snippets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Snippet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String commandLine;

    @Column(nullable = false)
    private String quickDescription;

    @Column(nullable = false)
    private String appName;

    @Column(name = "icon")
    private String icon = IconsPath.GENERIC.getPath();

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @Column(nullable = false, updatable = false)
    private Instant created = Instant.now();

    private Instant updated = Instant.now();

    private boolean isOfficial = false;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "snippets_fields", joinColumns = @JoinColumn(name = "snippet_id"), inverseJoinColumns = @JoinColumn(name = "field_id"))
    @JsonManagedReference
    @MapKey(name = "mapKey")
    @ToString.Exclude
    private Map<String, ComplementaryField> complementaryFields;

    /**
     * add a complementary field to snippet, provide a mapKey as first param to easily retrieve a field, and a field itself as a second param
     *
     * @param mapKey key used to retrieve a complementary field
     * @param field  complementary field of snippet
     */
    public void addComplementaryField(String mapKey, ComplementaryField field) {
        if (complementaryFields == null) {
            complementaryFields = new HashMap<>();
        }
        field.setSnippet(this);
        field.setMapKey(mapKey);
        complementaryFields.put(mapKey, field);
    }

    public void setIcon(IconsPath icon) {
        this.icon = icon.getPath();
    }
}

