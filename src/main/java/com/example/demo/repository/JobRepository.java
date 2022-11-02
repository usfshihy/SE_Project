package com.example.demo.repository;

import com.example.demo.domain.Job;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JobRepository extends PagingAndSortingRepository<Job, Long> {
    Iterable<Job> findByJobidOrJobnameOrJobdescOrAssignedWorkeridOrPriorityOrDuedateOrPhaseidOrComplete(String jobid, String jobName,
                                                                                                        String jobDesc, String assignedWorkerid, String priority, String dueDate, String phaseid, String complete);
}
