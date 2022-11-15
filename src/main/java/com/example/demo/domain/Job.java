package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

import static com.example.demo.domain.Job.*;

@Entity
@Table(name = COLLECTION_TITLE, uniqueConstraints= @UniqueConstraint(columnNames={FIELD_JOBNAME, FIELD_JOBDESC, FIELD_ASSIGNEDWORKERID,
        FIELD_PRIORITY, FIELD_DUEDATE, FIELD_PHASEID, FIELD_COMPLETE}))

@Data @NoArgsConstructor @RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"id"})

public class Job {
    public static final String COLLECTION_TITLE = "Jobs";
    public static final String FIELD_JOBNAME= "jobname";
    public static final String FIELD_JOBDESC = "jobdesc";
    public static final String FIELD_ASSIGNEDWORKERID = "assignedworkerid";
    public static final String FIELD_PRIORITY = "priority";
    public static final String FIELD_DUEDATE = "duedate";
    public static final String FIELD_PHASEID = "phaseid";
    public static final String FIELD_COMPLETE = "complete";

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(name = FIELD_JOBNAME)
    @NonNull
    private String jobname;

    @Column(name = FIELD_JOBDESC)
    @NonNull
    private String jobdesc;

    @Column(name = FIELD_ASSIGNEDWORKERID)
    @NonNull
    private String assignedworkerid;

    @Column(name = FIELD_PRIORITY)
    @NonNull
    private String priority;

    @Column(name = FIELD_DUEDATE)
    @NonNull
    private String duedate;

    @Column(name = FIELD_PHASEID)
    @NonNull
    private String phaseid;

    @Column(name = FIELD_COMPLETE)
    @NonNull
    private String complete;
}