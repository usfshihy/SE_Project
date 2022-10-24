package com.example.demo.repository;


import com.example.demo.domain.Defect;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DefectRepository extends PagingAndSortingRepository<Defect, Long> {

    Iterable<Defect> findByInspectoridOrInspectornameOrDefectdescOrProjectidOrPhaseidOrJobidOrPriorityOrIssuedateOrFixed(String inspectorid, String inspectorname,
           String defectdesc, String projectid, String phaseid, String jobid, String priority, String issuedate, String fixed);

}