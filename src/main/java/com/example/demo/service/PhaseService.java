package com.example.demo.service;

import com.example.demo.domain.Phase;

import java.util.List;

public interface PhaseService {
    Phase add(String phaseName, String phaseDesc, String phaseLeaderid, String teamSize, String priority,
              String dueDate, String processType, String projectid, String complete) throws Exception;
    long getCount();
    List<Phase> getAll(int page, int amountByOnePage);
    Phase findById(long id) throws Exception;
    List<Phase> find(String phaseName, String phaseDesc, String phaseLeaderid, String teamSize, String priority,
                     String dueDate, String processType, String projectid, String complete) throws Exception;
    Phase update(long id, String phaseName, String phaseDesc, String phaseLeaderid, String teamSize, String priority,
                 String dueDate, String processType, String projectid, String complete) throws Exception;
    void deleteAll();
}
