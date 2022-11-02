package com.example.demo.repository;

import com.example.demo.domain.Phase;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PhaseRepository extends PagingAndSortingRepository<Phase, Long> {
    Iterable<Phase> findByPhaseidOrPhasenameOrPhasedescOrPhaseLeaderidOrTeamsizeOrPriorityOrDuedateOrProcesstypeOrProjectidOrComplete(String phaseid, String phaseName, String phaseDesc, String phaseLeaderid, String teamSize, String priority,
                           String dueDate, String processType, String projectid, String complete);
}
