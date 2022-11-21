package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

import static com.example.demo.domain.Project.*;

@Entity
@Table(name = COLLECTION_TITLE, uniqueConstraints= @UniqueConstraint(columnNames={FIELD_NAME, FIELD_DESC, FIELD_PROJECTLEADERID, FIELD_CATEGORY, FIELD_COMPANY,
        FIELD_BRANCH, FIELD_PROCESSTYPE, FIELD_PRIORITY, FIELD_DUEBYDATE, FIELD_ISCOMPLETE}))
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
public class Project {

    public static final String COLLECTION_TITLE = "Projects";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_DESC = "desc";
    public static final String FIELD_PROJECTLEADERID = "projectleaderid";
    public static final String FIELD_CATEGORY = "category";
    public static final String FIELD_COMPANY = "company";
    public static final String FIELD_BRANCH = "branch";
    public static final String FIELD_PROCESSTYPE = "processtype";
    public static final String FIELD_PRIORITY = "priority";
    public static final String FIELD_DUEBYDATE = "duebydate";
    public static final String FIELD_ISCOMPLETE = "iscomplete";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(name = FIELD_NAME)
    @NonNull
    private String name;

    @Column(name = FIELD_DESC)
    @NonNull
    private String desc;

    @Column(name = FIELD_PROJECTLEADERID)
    @NonNull
    private String projectleaderid;

    @Column(name = FIELD_CATEGORY)
    @NonNull
    private String category;

    @Column(name = FIELD_COMPANY)
    @NonNull
    private String company;

    @Column(name = FIELD_BRANCH)
    @NonNull
    private String branch;

    @Column(name = FIELD_PRIORITY)
    @NonNull
    private String priority;

    @Column(name = FIELD_PROCESSTYPE)
    @NonNull
    private String processtype;

    @Column(name = FIELD_DUEBYDATE)
    @NonNull
    private String duebydate;

    @Column(name = FIELD_ISCOMPLETE)
    @NonNull
    private String iscomplete;
}