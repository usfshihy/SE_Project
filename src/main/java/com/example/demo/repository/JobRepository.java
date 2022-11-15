package com.example.demo.repository;

import com.example.demo.domain.Job;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JobRepository extends PagingAndSortingRepository<Job, Long> {
    Iterable<Job> findByJobnameOrJobdescOrAssignedworkeridOrPriorityOrDuedateOrPhaseidOrComplete(String jobname, String jobdesc, String assignedworkerid, String priority, String duedate, String phaseid, String complete);
}