package com.example.demo.service;

import com.example.demo.domain.Phase;

import java.util.List;

public interface PhaseService {

    Phase add(String phasename, String phasedesc, String phaseleaderid, String teamsize, String priority,
              String duedate, String processtype, String projectid, String complete) throws Exception;

    long getCount();

    List<Phase> getAll(int page, int amountByOnePage);

    Phase findById(long id) throws Exception;

    List<Phase> find(String phasename, String phasedesc, String phaseleaderid, String teamsize, String priority,
                     String duedate, String processtype, String projectid, String complete) throws Exception;

    Phase update(long id, String phasename, String phasedesc, String phaseleaderid, String teamsize, String priority,
                 String duedate, String processtype, String projectid, String complete) throws Exception;

    void deleteAll();
}