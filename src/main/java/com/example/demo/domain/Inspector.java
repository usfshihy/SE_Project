package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

import static com.example.demo.domain.Inspector.*;
import static  com.example.demo.domain.Inspector.COLLECTION_TITLE;
import static  com.example.demo.domain.Inspector.FIELD_MAJORDFOUND;
import static  com.example.demo.domain.Inspector.FIELD_MINORDFOUND;
import static  com.example.demo.domain.Inspector.FIELD_PDSIZE;
import static  com.example.demo.domain.Inspector.FIELD_PDTIME;
import static  com.example.demo.domain.Inspector.FIELD_PDRATE;
import static  com.example.demo.domain.Inspector.FIELD_ESTYIELD;

@Entity @Table(name = COLLECTION_TITLE, uniqueConstraints= @UniqueConstraint(columnNames={FIELD_MAJORDFOUND, FIELD_MAJORDFOUND, FIELD_MINORDFOUND, FIELD_PDSIZE,
        FIELD_PDTIME, FIELD_PDRATE, FIELD_ESTYIELD}))
@Data @NoArgsConstructor @RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
public class Inspector {

    public static final String COLLECTION_TITLE = "Inspectors";
    public static final String FIELD_MAJORDFOUND = "majord";
    public static final String FIELD_MINORDFOUND = "minord";
    public static final String FIELD_PDSIZE = "pdsize";
    public static final String FIELD_PDTIME = "pdtime";
    public static final String FIELD_PDRATE = "pdrate";
    public static final String FIELD_ESTYIELD = "estyield";

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(name = FIELD_MAJORDFOUND)
    @NonNull
    private String majord;

    @Column(name = FIELD_MINORDFOUND)
    @NonNull
    private String minord;

    @Column(name = FIELD_PDSIZE)
    @NonNull
    private String pdsize;

    @Column(name = FIELD_PDTIME)
    @NonNull
    private String pdtime;

    @Column(name = FIELD_PDRATE)
    @NonNull
    private String pdrate;

    @Column(name = FIELD_ESTYIELD)
    @NonNull
    private String estyield;
}