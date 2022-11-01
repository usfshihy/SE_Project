package com.example.demo.service;

import com.example.demo.domain.Project;
import com.example.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.demo.service.HandlerException.EMPTY_RESULT_BY_ID_ERROR_STRING;
import static com.example.demo.service.HandlerException.handlerException;
@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project add(String name, String DESC, int projectLeaderID, String category,
                       String company, String branch, String priority, String processType,
                       Date dueByDatee, Boolean isComplete) throws Exception {
        Project project = new Project( name, DESC,  projectLeaderID, category,
                company,branch,  priority, processType,
                 dueByDatee,isComplete);
        try {
            projectRepository.save(project);
        }
        catch(DataIntegrityViolationException exception) {
            handlerException(exception, project.toString());
        }
        return project;
    }

    @Override
    public long getCount() {
        return projectRepository.count();
    }

    @Override
    public List<Project> getAll(int page, int amountByOnePage) {
        return projectRepository.findAll(PageRequest.of(page,amountByOnePage)).getContent();
    }

    @Override
    public Project findById(long id) {
        Project byId = projectRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Project.class.getSimpleName(), id)));
        return byId;
    }

    @Override
    public List<Project> find(String name, String DESC, int projectLeaderID, String category,
                              String company, String branch, String priority, String processType,
                              Date dueByDatee, Boolean isComplete) throws Exception {
        List<Project> projects = new ArrayList<>();
        try {
            projectRepository.findByNameOrOtherFields(name, DESC,  projectLeaderID, category,
                    company,branch,  priority, processType,
                    dueByDatee,isComplete).forEach(projects::add);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Project.class.getSimpleName());
        }
        return projects;
    }



    @Override
    public Project update(long id, String name, String DESC, int projectLeaderID, String category,
                          String company, String branch, String priority, String processType,
                          Date dueByDatee, Boolean isComplete) throws Exception {
        Project project = projectRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Project.class.getSimpleName(), id)));
        if(name!= null)
            project.setName(name);
        if(DESC!=null)
            project.setDESC(DESC);
        if(projectLeaderID!= 0)
            project.setProjectLeaderID(projectLeaderID);
        if(category!=null)
            project.setCategory(category);
        if(company!= null)
            project.setCompany(company);
        if(branch!=null)
            project.setBranch(branch);
        if(priority!=null)
            project.setPriority(priority);
        if(processType!=null)
            project.setProcessType(processType);
        if(isComplete!=null)
            project.setIsComplete(isComplete);
        if(dueByDatee!=null)
            project.setDueByDate(dueByDatee);
        try {
            projectRepository.save(project);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Project.class.getSimpleName());
        }
        return project;
    }

    @Override
    public void deleteAll() {
        projectRepository.deleteAll();
    }
}
