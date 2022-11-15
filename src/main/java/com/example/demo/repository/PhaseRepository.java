package com.example.demo.repository;

import com.example.demo.domain.Phase;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PhaseRepository extends PagingAndSortingRepository<Phase, Long> {
    Iterable<Phase> findByPhasenameOrPhasedescOrPhaseleaderidOrTeamsizeOrPriorityOrDuedateOrProcesstypeOrProjectidOrComplete(String phasename, String phasedesc, String phaseleaderid, String teamsize, String priority,
                                                                                                                             String duedate, String processtype, String projectid, String complete);
}