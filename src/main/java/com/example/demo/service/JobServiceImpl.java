package com.example.demo.service;

import com.example.demo.domain.Job;
import com.example.demo.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.service.HandlerException.EMPTY_RESULT_BY_ID_ERROR_STRING;
import static com.example.demo.service.HandlerException.handlerException;

public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;


    @Override
    public Job add(String jobid, String jobName, String jobDesc, String assignedWorkerid, String priority, String dueDate, String phaseid, String complete) throws Exception {
        Job job = new Job(jobid, jobName, jobDesc, assignedWorkerid, priority, dueDate, phaseid, complete);
        try {
            jobRepository.save(job);
        }
        catch (DataIntegrityViolationException exception){
            handlerException(exception, job.toString());
        }
        return job;
    }

    @Override
    public long getCount() {
        return 0;
    }

    @Override
    public List<Job> getAll(int page, int amountByOnePage) {
        return jobRepository.findAll(PageRequest.of(page,amountByOnePage)).getContent();
    }

    @Override
    public Job findById(long id) {
        Job byId = jobRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Job.class.getSimpleName(), id)));
        return byId;
    }

    @Override
    public List<Job> find(String jobid, String jobName, String jobDesc, String assignedWorkerid, String priority, String dueDate, String phaseid, String complete) throws Exception {
        List<Job> jobs = new ArrayList<>();
        try {
            jobRepository.findByJobidOrJobnameOrJobdescOrAssignedWorkeridOrPriorityOrDuedateOrPhaseidOrComplete(jobid, jobName, jobDesc, assignedWorkerid,
                    priority, dueDate, phaseid, complete).forEach(jobs::add);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Job.class.getSimpleName());
        }
        return jobs;
    }

    @Override
    public Job update(long id, String jobid, String jobName, String jobDesc, String assignedWorkerid, String priority, String dueDate, String phaseid, String complete) throws Exception {
        Job job = jobRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Job.class.getSimpleName(), id)));
        if(jobid!= null)
            job.setJobid(jobid);
        if(jobName!= null)
            job.setJobName(jobName);
        if(jobDesc!= null)
            job.setJobDesc(jobDesc);
        if(assignedWorkerid!= null)
            job.setAssignedWorkerid(assignedWorkerid);
        if(priority!= null)
            job.setPriority(priority);
        if(dueDate!= null)
            job.setDueDate(dueDate);
        if(phaseid!= null)
            job.setPhaseid(phaseid);
        if(complete!= null)
            job.setComplete(complete);
        try {
            jobRepository.save(job);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Job.class.getSimpleName());
        }
        return job;
    }

    @Override
    public void deleteAll() {
        jobRepository.deleteAll();
    }
}
