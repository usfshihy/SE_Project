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
    public static final String FIELD_PHASENAME= "phaseName";
    public static final String FIELD_PHASEDESC = "phaseDesc";
    public static final String FIELD_PHASELEADERID = "phaseLeaderid";
    public static final String FIELD_TEAMSIZE = "teamSize";
    public static final String FIELD_PRIORITY = "priority";
    public static final String FIELD_DUEDATE = "dueDate";
    public static final String FIELD_PROCESSTYPE = "processType";
    public static final String FIELD_PROJECTID = "projectid";
    public static final String FIELD_COMPLETE = "complete";

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(name = FIELD_PHASENAME)
    @NonNull
    private String phaseName;

    @Column(name = FIELD_PHASEDESC)
    @NonNull
    private String phaseDesc;

    @Column(name = FIELD_PHASELEADERID)
    @NonNull
    private String phaseLeaderid;

    @Column(name = FIELD_TEAMSIZE)
    @NonNull
    private String teamSize;

    @Column(name = FIELD_PRIORITY)
    @NonNull
    private String priority;

    @Column(name = FIELD_DUEDATE)
    @NonNull
    private String dueDate;

    @Column(name = FIELD_PROCESSTYPE)
    @NonNull
    private String processType;

    @Column(name = FIELD_PROJECTID)
    @NonNull
    private String projectid;

    @Column(name = FIELD_COMPLETE)
    @NonNull
    private String complete;
}
