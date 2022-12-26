package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

import java.util.Date;

import static com.example.demo.domain.Member.*;

@Entity
@Table(name = COLLECTION_TITLE, uniqueConstraints= @UniqueConstraint(columnNames={FIELD_FIRSTNAME, FIELD_LASTNAME, FIELD_COMPANY, FIELD_BRANCH,
        FIELD_ADDRESS, FIELD_COMPANYPOSITION, FIELD_DATEOFBIRTH, FIELD_DATEOFJOININGCOMPANY}))
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
public class Member {

    public static final String COLLECTION_TITLE = "Members";
    public static final String FIELD_FIRSTNAME = "firstname";
    public static final String FIELD_LASTNAME = "lastname";
    public static final String FIELD_COMPANY = "company";

    public static final String FIELD_BRANCH = "branch";
    public static final String FIELD_ADDRESS = "address";
    public static final String FIELD_COMPANYPOSITION = "companyposition";
    public static final String FIELD_DATEOFBIRTH = "dateofbirth";

    public static final String FIELD_DATEOFJOININGCOMPANY = "dateofjoiningcompany";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(name = FIELD_FIRSTNAME)
    @NonNull
    private String firstname;

    @Column(name = FIELD_LASTNAME)
    @NonNull
    private String lastname;

    @Column(name = FIELD_COMPANY)
    @NonNull
    private String company;

    @Column(name = FIELD_BRANCH)
    @NonNull
    private String branch;

    @Column(name = FIELD_ADDRESS)
    @NonNull
    private String address;

    @Column(name = FIELD_COMPANYPOSITION)
    @NonNull
    private String companyposition;

    @Column(name = FIELD_DATEOFBIRTH)
    @NonNull
    private String dateofbirth;

    @Column(name = FIELD_DATEOFJOININGCOMPANY)
    @NonNull
    private String dateofjoiningcompany;
}