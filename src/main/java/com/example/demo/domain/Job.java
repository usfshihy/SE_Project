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
    public static final String COLLECTION_TITLE = "Job";
    public static final String FIELD_JOBNAME= "jobName";
    public static final String FIELD_JOBDESC = "jobDesc";
    public static final String FIELD_ASSIGNEDWORKERID = "assignedWorkerid";
    public static final String FIELD_PRIORITY = "priority";
    public static final String FIELD_DUEDATE = "dueDate";
    public static final String FIELD_PHASEID = "phaseid";
    public static final String FIELD_COMPLETE = "complete";

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(name = FIELD_JOBNAME)
    @NonNull
    private String jobName;

    @Column(name = FIELD_JOBDESC)
    @NonNull
    private String jobDesc;

    @Column(name = FIELD_ASSIGNEDWORKERID)
    @NonNull
    private String assignedWorkerid;

    @Column(name = FIELD_PRIORITY)
    @NonNull
    private String priority;

    @Column(name = FIELD_DUEDATE)
    @NonNull
    private String dueDate;

    @Column(name = FIELD_PHASEID)
    @NonNull
    private String phaseid;
    //
    @Column(name = FIELD_COMPLETE)
    @NonNull
    private String complete;
}
