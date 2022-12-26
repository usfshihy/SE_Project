package com.example.demo.service;

import com.example.demo.domain.Project;
import com.example.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.service.HandlerException.EMPTY_RESULT_BY_ID_ERROR_STRING;
import static com.example.demo.service.HandlerException.handlerException;
@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project add(String name, String desc,
                       String projectleaderid, String category, String company, String branch, String priority, String processtype, String duebydate, String iscomplete) throws Exception {
        Project project = new Project( name, desc, projectleaderid, category, company, branch, priority, processtype, duebydate, iscomplete);
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
    public List<Project> find(String name, String desc,
                              String projectleaderid, String category, String company, String branch, String priority, String processtype, String duebydate,
                              String iscomplete) throws Exception {
        List<Project> projects = new ArrayList<>();
        try {
            projectRepository.findByNameOrDescOrProjectleaderidOrCategoryOrCompanyOrBranchOrPriorityOrProcesstypeOrDuebydateOrIscomplete( name, desc,
                    projectleaderid, category, company, branch, priority, processtype, duebydate, iscomplete).forEach(projects::add);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Project.class.getSimpleName());
        }
        return projects;
    }



    @Override
    public Project update(long id, String name, String desc,
                          String projectleaderid, String category, String company, String branch, String priority, String processtype, String duebydate,
                          String iscomplete) throws Exception {
        Project project = projectRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Project.class.getSimpleName(), id)));
        if(name!= null)
            project.setName(name);
        if(desc!=null)
            project.setDesc(desc);
        if(projectleaderid!= null)
            project.setProjectleaderid(projectleaderid);
        if(category!=null)
            project.setCategory(category);
        if(company!= null)
            project.setCompany(company);
        if(branch!=null)
            project.setBranch(branch);
        if(priority!=null)
            project.setPriority(priority);
        if(processtype!=null)
            project.setProcesstype(processtype);
        if(iscomplete!=null)
            project.setIscomplete(iscomplete);
        if(duebydate!=null)
            project.setDuebydate(duebydate);
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
