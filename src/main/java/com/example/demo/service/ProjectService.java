package com.example.demo.service;

import com.example.demo.domain.Project;

import java.util.Date;
import java.util.List;

public interface ProjectService {
    Project add(String name, String DESC, int projectLeaderID, String category,
                String company, String branch, String priority, String processType,
                Date dueByDatee, Boolean isComplete) throws Exception;
    long getCount();
    List<Project> getAll(int page, int amountByOnePage);
    Project findById(long id) throws Exception;
    List<Project> find(String name, String DESC, int projectLeaderID, String category,
                       String company, String branch, String priority, String processType,
                       Date dueByDatee, Boolean isComplete) throws Exception;
    Project update(long id, String name, String DESC, int projectLeaderID, String category,
                   String company, String branch, String priority, String processType,
                   Date dueByDatee, Boolean isComplete) throws Exception;
    void deleteAll();
}
