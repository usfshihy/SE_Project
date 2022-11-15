package com.example.demo.service;

import com.example.demo.domain.Phase;
import com.example.demo.repository.PhaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.service.HandlerException.EMPTY_RESULT_BY_ID_ERROR_STRING;
import static com.example.demo.service.HandlerException.handlerException;

@Service
public class PhaseServiceImpl implements PhaseService{

    @Autowired
    private PhaseRepository phaseRepository;

    @Override
    public Phase add(String phasename, String phasedesc, String phaseleaderid, String teamsize, String priority,
                     String duedate, String processtype, String projectid, String complete) throws Exception {
        Phase phase = new Phase(phasename, phasedesc, phaseleaderid, teamsize, priority, duedate, processtype, projectid, complete);
        try {
            phaseRepository.save(phase);
        }
        catch(DataIntegrityViolationException exception) {
            handlerException(exception, phase.toString());
        }
        return phase;
    }

    @Override
    public long getCount() {
        return phaseRepository.count();
    }

    @Override
    public List<Phase> getAll(int page, int amountByOnePage) {
        return phaseRepository.findAll(PageRequest.of(page,amountByOnePage)).getContent();
    }

    @Override
    public Phase findById(long id) throws Exception {
        Phase byId = phaseRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Phase.class.getSimpleName(), id)));
        return byId;
    }

    @Override
    public List<Phase> find(String phasename, String phasedesc, String phaseleaderid, String teamsize, String priority,
                            String duedate, String processtype, String projectid, String complete) throws Exception {
        List<Phase> phases = new ArrayList<>();
        try{
            phaseRepository.findByPhasenameOrPhasedescOrPhaseleaderidOrTeamsizeOrPriorityOrDuedateOrProcesstypeOrProjectidOrComplete(phasename, phasedesc,
                    phaseleaderid, teamsize, priority, duedate, processtype, projectid, complete).forEach(phases::add);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Phase.class.getSimpleName());
        }
        return phases;
    }

    @Override
    public Phase update(long id, String phasename, String phasedesc, String phaseleaderid, String teamsize, String priority,
                        String duedate, String processtype, String projectid, String complete) throws Exception {
        Phase phase = phaseRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Phase.class.getSimpleName(), id)));
        if(phasename!= null)
            phase.setPhasename(phasename);
        if(phasedesc!= null)
            phase.setPhasedesc(phasedesc);
        if(phaseleaderid!= null)
            phase.setPhaseleaderid(phaseleaderid);
        if(teamsize!= null)
            phase.setTeamsize(teamsize);
        if(priority!= null)
            phase.setPriority(priority);
        if(duedate!= null)
            phase.setDuedate(duedate);
        if(processtype!= null)
            phase.setProcesstype(processtype);
        if(projectid!= null)
            phase.setProjectid(projectid);
        if(complete!= null)
            phase.setComplete(complete);
        try {
            phaseRepository.save(phase);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Phase.class.getSimpleName());
        }
        return phase;
    }

    @Override
    public void deleteAll() {
        phaseRepository.deleteAll();
    }
}