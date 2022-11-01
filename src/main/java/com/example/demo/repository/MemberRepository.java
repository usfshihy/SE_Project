package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.Date;

public interface MemberRepository  extends PagingAndSortingRepository<Member, Long> {

    Iterable<Member> findByFirstnameOrLastnameOrOtherFields(String firstname, String lastname, String company,
                                                            String branch, String address, String companyPosition,
                                                            Date dateOfBirth, Date dateOfJoiningCompany);
}