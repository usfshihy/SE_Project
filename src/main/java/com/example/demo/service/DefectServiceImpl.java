package com.example.demo.service;


import com.example.demo.domain.Defect;
import com.example.demo.repository.DefectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.service.HandlerException.EMPTY_RESULT_BY_ID_ERROR_STRING;
import static com.example.demo.service.HandlerException.handlerException;

@Service
public class DefectServiceImpl implements DefectService {

    @Autowired
    private DefectRepository defectRepository;

    @Override
    public Defect add(String inspectorid, String inspectorname, String defectdesc, String projectid, String phaseid, String jobid, String priority,
                      String issuedate, String fixed) throws Exception {
        Defect defect = new Defect(inspectorid, inspectorname, defectdesc, projectid, phaseid, jobid, priority, issuedate, fixed);
        try {
            defectRepository.save(defect);
        }
        catch(DataIntegrityViolationException exception) {
            handlerException(exception, defect.toString());
        }
        return defect;
    }

    @Override
    public long getCount() {
        return defectRepository.count();
    }

    @Override
    public List<Defect> getAll(int page, int amountByOnePage) {
        return defectRepository.findAll(PageRequest.of(page,amountByOnePage)).getContent();
    }

    @Override
    public Defect findById(long id) {
        Defect byId = defectRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Defect.class.getSimpleName(), id)));
        return byId;
    }

    @Override
    public List<Defect> find(String inspectorid, String inspectorname, String defectdesc, String projectid, String phaseid, String jobid, String priority,
                             String issuedate, String fixed) throws Exception {
        List<Defect> defects = new ArrayList<>();
        try {
            defectRepository.findByInspectoridOrInspectornameOrDefectdescOrProjectidOrPhaseidOrJobidOrPriorityOrIssuedateOrFixed(inspectorid, inspectorname, defectdesc,
                    projectid, phaseid, jobid, priority, issuedate, fixed).forEach(defects::add);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Defect.class.getSimpleName());
        }
        return defects;
    }



    @Override
    public Defect update(long id, String inspectorid, String inspectorname, String defectdesc, String projectid, String phaseid, String jobid, String priority,
                         String issuedate, String fixed) throws Exception {
        Defect defect = defectRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Defect.class.getSimpleName(), id)));
        if(inspectorid!= null)
            defect.setInspectorid(inspectorid);
        if(inspectorname!= null)
            defect.setInspectorname(inspectorname);
        if(defectdesc!= null)
            defect.setDefectdesc(defectdesc);
        if(projectid!= null)
            defect.setProjectid(projectid);
        if(phaseid!= null)
            defect.setPhaseid(phaseid);
        if(jobid!= null)
            defect.setJobid(jobid);
        if(priority!= null)
            defect.setPriority(priority);
        if(issuedate!= null)
            defect.setIssuedate(issuedate);
        if(fixed!= null)
            defect.setFixed(fixed);
        try {
            defectRepository.save(defect);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Defect.class.getSimpleName());
        }
        return defect;
    }

    @Override
    public void deleteAll() {
        defectRepository.deleteAll();
    }
}
