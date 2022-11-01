package com.example.demo.repository;

import com.example.demo.domain.Project;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;

public interface ProjectRepository  extends PagingAndSortingRepository<Project, Long> {

    Iterable<Project> findByNameOrOtherFields ( String name, String DESC, int projectLeaderID, String category,
                                                String company, String branch, String priority, String processType,
                                                Date dueByDatee, Boolean isComplete);
}