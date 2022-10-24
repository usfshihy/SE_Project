package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

import static  com.example.demo.domain.Author.COLLECTION_TITLE;
import static  com.example.demo.domain.Author.FIELD_FIRSTNAME;
import static  com.example.demo.domain.Author.FIELD_LASTNAME;

@Entity @Table(name = COLLECTION_TITLE, uniqueConstraints= @UniqueConstraint(columnNames={FIELD_FIRSTNAME, FIELD_LASTNAME}))
@Data @NoArgsConstructor @RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
public class Author {

    public static final String COLLECTION_TITLE = "Authors";
    public static final String FIELD_FIRSTNAME = "firstname";
    public static final String FIELD_LASTNAME = "lastname";

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(name = FIELD_FIRSTNAME)
    @NonNull
    private String firstname;

    @Column(name = FIELD_LASTNAME)
    @NonNull
    private String lastname;
}