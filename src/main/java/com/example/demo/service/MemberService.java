package com.example.demo.service;

import com.example.demo.domain.Member;

import java.util.Date;
import java.util.List;

public interface MemberService {
    Member add(String firstname, String lastname, String company,
               String branch, String address, String companyposition, String dateofbirth, String dateofjoiningcompany) throws Exception;
    long getCount();
    List<Member> getAll(int page, int amountByOnePage);
    Member findById(long id) throws Exception;
    List<Member> find(String firstname, String lastname, String company,
                      String branch, String address, String companyposition, String dateofbirth, String dateofjoiningcompany) throws Exception;
    Member update(long id, String firstname, String lastname, String company,
                  String branch, String address, String companyposition, String dateofbirth, String dateofjoiningcompany) throws Exception;
    void deleteAll();
}
