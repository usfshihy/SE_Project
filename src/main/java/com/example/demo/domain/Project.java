package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

import java.util.Date;

import static com.example.demo.domain.Author.*;

@Entity
@Table(name = COLLECTION_TITLE, uniqueConstraints= @UniqueConstraint(columnNames={FIELD_FIRSTNAME, FIELD_LASTNAME}))
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
public class Project {

    public static final String COLLECTION_TITLE = "Project";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_DESC = "desc";

    public static final String FIELD_PROJECT_LEADER_ID = "ProjectLeaderID";
    public static final String FIELD_CATEGORY = "Category";
    public static final String FIELD_COMPANY = "Company";

    public static final String FIELD_BRANCH = "Branch";
    public static final String FIELD_PROCESS_TYPE = "ProcessType";
    public static final String FIELD_PRIORITY = "Priority";
    public static final String FIELD_DUE_BY_DATE = "DueByDate";
    public static final String FIELD_IS_COMPLETE = "IsComplete";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(name = FIELD_NAME)
    @NonNull
    private String name;

    @Column(name = FIELD_DESC)
    @NonNull
    private String DESC;

    @Column(name = FIELD_PROJECT_LEADER_ID)
    @NonNull
    private int projectLeaderID;

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

    @Column(name = FIELD_PROCESS_TYPE)
    @NonNull
    private String processType;

    @Column(name = FIELD_DUE_BY_DATE)
    @NonNull
    private Date dueByDate;

    @Column(name = FIELD_IS_COMPLETE)
    @NonNull
    private Boolean isComplete;
}
