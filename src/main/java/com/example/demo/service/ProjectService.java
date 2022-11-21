package com.example.demo.service;

import com.example.demo.domain.Project;

import java.util.Date;
import java.util.List;

public interface ProjectService {
    Project add(String name, String desc,
                String projectleaderid, String category, String company, String branch, String priority, String processtype, String duebydate, String iscomplete) throws Exception;
    long getCount();
    List<Project> getAll(int page, int amountByOnePage);
    Project findById(long id) throws Exception;
    List<Project> find(String name, String desc,
                       String projectleaderid, String category, String company, String branch, String priority, String processtype, String duebydate, String iscomplete) throws Exception;
    Project update(long id, String name, String desc,
                   String projectleaderid, String category, String company, String branch, String priority, String processtype, String duebydate, String iscomplete) throws Exception;
    void deleteAll();
}
