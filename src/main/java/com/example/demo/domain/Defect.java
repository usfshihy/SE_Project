package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

import static com.example.demo.domain.Defect.*;

@Entity @Table(name = COLLECTION_TITLE, uniqueConstraints= @UniqueConstraint(columnNames={FIELD_INSPECTORID, FIELD_INSPECTORNAME, FIELD_DEFECTDESC, FIELD_PROJECTID,
        FIELD_PHASEID, FIELD_JOBID, FIELD_PRIORITY, FIELD_ISSUEDATE, FIELD_FIXED}))
@Data @NoArgsConstructor @RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
public class Defect {

    public static final String COLLECTION_TITLE = "Defects";
    public static final String FIELD_INSPECTORID = "inspectorid";
    public static final String FIELD_INSPECTORNAME = "inspectorname";
    public static final String FIELD_DEFECTDESC = "defectdesc";
    public static final String FIELD_PROJECTID = "projectid";
    public static final String FIELD_PHASEID = "phaseid";
    public static final String FIELD_JOBID = "jobid";
    public static final String FIELD_PRIORITY = "priority";
    public static final String FIELD_ISSUEDATE = "issuedate";
    public static final String FIELD_FIXED = "fixed";

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(name = FIELD_INSPECTORID)
    @NonNull
    private String inspectorid;

    @Column(name = FIELD_INSPECTORNAME)
    @NonNull
    private String inspectorname;

    @Column(name = FIELD_DEFECTDESC)
    @NonNull
    private String defectdesc;

    @Column(name = FIELD_PROJECTID)
    @NonNull
    private String projectid;

    @Column(name = FIELD_PHASEID)
    @NonNull
    private String phaseid;

    @Column(name = FIELD_JOBID)
    @NonNull
    private String jobid;

    @Column(name = FIELD_PRIORITY)
    @NonNull
    private String priority;

    @Column(name = FIELD_ISSUEDATE)
    @NonNull
    private String issuedate;

    @Column(name = FIELD_FIXED)
    @NonNull
    private String fixed;
}