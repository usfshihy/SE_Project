package com.example.demo.service;


import com.example.demo.domain.Inspector;
import com.example.demo.repository.InspectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.service.HandlerException.EMPTY_RESULT_BY_ID_ERROR_STRING;
import static com.example.demo.service.HandlerException.handlerException;

@Service
public class InspectorServiceImpl implements InspectorService {

    @Autowired
    private InspectorRepository inspectorRepository;

    @Override
    public Inspector add(String majord, String minord, String pdsize, String pdtime, String pdrate, String estyield) throws Exception {
        Inspector inspector = new Inspector(majord, minord, pdsize, pdtime, pdrate, estyield);
        try {
            inspectorRepository.save(inspector);
        }
        catch(DataIntegrityViolationException exception) {
            handlerException(exception, inspector.toString());
        }
        return inspector;
    }

    @Override
    public long getCount() {
        return inspectorRepository.count();
    }

    @Override
    public List<Inspector> getAll(int page, int amountByOnePage) {
        return inspectorRepository.findAll(PageRequest.of(page,amountByOnePage)).getContent();
    }

    @Override
    public Inspector findById(long id) {
        Inspector byId = inspectorRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Inspector.class.getSimpleName(), id)));
        return byId;
    }

    @Override
    public List<Inspector> find(String majord, String minord, String pdsize, String pdtime, String pdrate, String estyield) throws Exception {
        List<Inspector> inspectors = new ArrayList<>();
        try {
            inspectorRepository.findByMajordOrMinordOrPdsizeOrPdtimeOrPdrateOrEstyield(majord, minord, pdsize, pdtime, pdrate, estyield).forEach(inspectors::add);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Inspector.class.getSimpleName());
        }
        return inspectors;
    }



    @Override
    public Inspector update(long id, String majord, String minord, String pdsize, String pdtime, String pdrate, String estyield) throws Exception {
        Inspector inspector = inspectorRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Inspector.class.getSimpleName(), id)));
        if(majord!= null)
            inspector.setMajord(majord);
        if(minord!= null)
            inspector.setMinord(minord);
        if(pdsize!= null)
            inspector.setPdsize(pdsize);
        if(pdtime!= null)
            inspector.setPdtime(pdtime);
        if(pdrate!= null)
            inspector.setPdrate(pdrate);
        if(estyield!= null)
            inspector.setEstyield(estyield);
        try {
            inspectorRepository.save(inspector);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Inspector.class.getSimpleName());
        }
        return inspector;
    }

    @Override
    public void deleteAll() {
        inspectorRepository.deleteAll();
    }
}
