package com.example.demo.domain;

import lombok.*;
import javax.persistence.*;

import static com.example.demo.domain.Phase.*;

@Entity @Table(name = COLLECTION_TITLE, uniqueConstraints= @UniqueConstraint(columnNames={FIELD_PHASENAME, FIELD_PHASEDESC, FIELD_PHASELEADERID,
        FIELD_TEAMSIZE, FIELD_PRIORITY, FIELD_DUEDATE, FIELD_PROCESSTYPE, FIELD_PROJECTID, FIELD_COMPLETE}))

@Data @NoArgsConstructor @RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"id"})

public class Phase {
    public static final String COLLECTION_TITLE = "Phases";
    public static final String FIELD_PHASENAME= "phasename";
    public static final String FIELD_PHASEDESC = "phasedesc";
    public static final String FIELD_PHASELEADERID = "phaseleaderid";
    public static final String FIELD_TEAMSIZE = "teamsize";
    public static final String FIELD_PRIORITY = "priority";
    public static final String FIELD_DUEDATE = "duedate";
    public static final String FIELD_PROCESSTYPE = "processtype";
    public static final String FIELD_PROJECTID = "projectid";
    public static final String FIELD_COMPLETE = "complete";

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(name = FIELD_PHASENAME)
    @NonNull
    private String phasename;

    @Column(name = FIELD_PHASEDESC)
    @NonNull
    private String phasedesc;

    @Column(name = FIELD_PHASELEADERID)
    @NonNull
    private String phaseleaderid;

    @Column(name = FIELD_TEAMSIZE)
    @NonNull
    private String teamsize;

    @Column(name = FIELD_PRIORITY)
    @NonNull
    private String priority;

    @Column(name = FIELD_DUEDATE)
    @NonNull
    private String duedate;

    @Column(name = FIELD_PROCESSTYPE)
    @NonNull
    private String processtype;

    @Column(name = FIELD_PROJECTID)
    @NonNull
    private String projectid;

    @Column(name = FIELD_COMPLETE)
    @NonNull
    private String complete;
}
