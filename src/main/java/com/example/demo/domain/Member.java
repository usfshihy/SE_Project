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
public class Member {

    public static final String COLLECTION_TITLE = "Member";
    public static final String FIELD_FIRSTNAME = "firstname";
    public static final String FIELD_LASTNAME = "lastname";
    public static final String FIELD_COMPANY = "Company";

    public static final String FIELD_BRANCH = "Branch";
    public static final String FIELD_ADDRESS = "Address";
    public static final String FIELD_COMPANY_POSITION = "CompanyPosition";
    public static final String FIELD_DATE_OF_BIRTH = "DateOfBirth";
    public static final String FIELD_DATE_OF_JOINING_COMPANY = "DateOfJoiningCompany";

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

    @Column(name = FIELD_COMPANY_POSITION)
    @NonNull
    private String companyPosition;

    @Column(name = FIELD_DATE_OF_BIRTH)
    @NonNull
    private Date dateOfBirth;

    @Column(name = FIELD_DATE_OF_JOINING_COMPANY)
    @NonNull
    private Date dateOfJoiningCompany;
}
