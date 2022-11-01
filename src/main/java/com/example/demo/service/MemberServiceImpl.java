package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.demo.service.HandlerException.EMPTY_RESULT_BY_ID_ERROR_STRING;
import static com.example.demo.service.HandlerException.handlerException;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member add(String firstname, String lastname, String company,
                      String branch, String address, String companyPosition,
                      Date dateOfBirth, Date dateOfJoiningCompany) throws Exception {
        Member member = new Member( firstname,  lastname,  company,
                branch, address,  companyPosition,
                dateOfBirth,  dateOfJoiningCompany);
        try {
            memberRepository.save(member);
        }
        catch(DataIntegrityViolationException exception) {
            handlerException(exception, member.toString());
        }
        return member;
    }

    @Override
    public long getCount() {
        return memberRepository.count();
    }

    @Override
    public List<Member> getAll(int page, int amountByOnePage) {
        return memberRepository.findAll(PageRequest.of(page,amountByOnePage)).getContent();
    }

    @Override
    public Member findById(long id) {
        Member byId = memberRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Member.class.getSimpleName(), id)));
        return byId;
    }

    @Override
    public List<Member> find(String firstname, String lastname, String company,
                             String branch, String address, String companyPosition,
                             Date dateOfBirth, Date dateOfJoiningCompany) throws Exception {
        List<Member> members = new ArrayList<>();
        try {
            memberRepository.findByFirstnameOrLastnameOrOtherFields( firstname,  lastname,  company,
                    branch, address,  companyPosition,
                    dateOfBirth,  dateOfJoiningCompany).forEach(members::add);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Member.class.getSimpleName());
        }
        return members;
    }



    @Override
    public Member update(long id, String firstname, String lastname, String company,
                         String branch, String address, String companyPosition,
                         Date dateOfBirth, Date dateOfJoiningCompany) throws Exception {
        Member member = memberRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Member.class.getSimpleName(), id)));
        if(firstname!= null)
            member.setFirstname(firstname);
        if(lastname!=null)
            member.setLastname(lastname);
        if(company!= null)
            member.setCompany(company);
        if(branch!=null)
            member.setBranch(branch);
        if(address!= null)
            member.setAddress(address);
        if(companyPosition!=null)
            member.setCompanyPosition(companyPosition);
        if(dateOfBirth!= null)
            member.setDateOfBirth(dateOfBirth);
        if(dateOfJoiningCompany!=null)
            member.setDateOfJoiningCompany(dateOfJoiningCompany);
        try {
            memberRepository.save(member);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Member.class.getSimpleName());
        }
        return member;
    }

    @Override
    public void deleteAll() {
        memberRepository.deleteAll();
    }
}
