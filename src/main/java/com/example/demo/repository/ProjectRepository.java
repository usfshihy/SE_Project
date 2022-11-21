package com.example.demo.repository;

import com.example.demo.domain.Project;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface ProjectRepository  extends PagingAndSortingRepository<Project, Long> {

    Iterable<Project> findByNameOrDescOrProjectleaderidOrCategoryOrCompanyOrBranchOrPriorityOrProcesstypeOrDuebydateOrIscomplete ( String name, String desc,
                                    String projectleaderid, String category, String company, String branch, String priority, String processtype, String duebydate, String iscomplete);
}