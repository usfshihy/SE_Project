package com.example.demo.service;

import com.example.demo.domain.Job;

import java.util.List;

public interface JobService {

    Job add(String jobname, String jobdesc, String assignedworkerid, String priority, String duedate,
            String phaseid, String complete) throws Exception;

    long getCount();

    List<Job> getAll(int page, int amountByOnePage);

    Job findById(long id) throws Exception;

    List<Job> find(String jobname, String jobdesc, String assignedworkerid, String priority, String duedate,
                   String phaseid, String complete) throws Exception;

    Job update(long id, String jobname, String jobdesc, String assignedworkerid, String priority, String duedate,
               String phaseid, String complete) throws Exception;

    void deleteAll();
}