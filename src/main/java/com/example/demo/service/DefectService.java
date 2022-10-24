package com.example.demo.service;

import com.example.demo.domain.Defect;

import java.util.List;

public interface DefectService {

    Defect add(String inspectorid, String inspectorname, String defectdesc, String projectid, String phaseid, String jobid, String priority,
                  String issuedate, String fixed) throws Exception;
    long getCount();
    List<Defect> getAll(int page, int amountByOnePage);
    Defect findById(long id) throws Exception;
    List<Defect> find(String inspectorid, String inspectorname, String defectdesc, String projectid, String phaseid, String jobid, String priority,
                      String issuedate, String fixed) throws Exception;
    Defect update(long id, String inspectorid, String inspectorname, String defectdesc, String projectid, String phaseid, String jobid, String priority,
                  String issuedate, String fixed) throws Exception;
   void deleteAll();
}