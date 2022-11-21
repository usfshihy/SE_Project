package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MemberRepository  extends PagingAndSortingRepository<Member, Long> {

    Iterable<Member> findByFirstnameOrLastnameOrCompanyOrBranchOrAddressOrCompanypositionOrDateofbirthOrDateofjoiningcompany(String firstname, String lastname, String company,
                                                            String branch, String address, String companyposition, String dateofbirth, String dateofjoiningcompany);
}