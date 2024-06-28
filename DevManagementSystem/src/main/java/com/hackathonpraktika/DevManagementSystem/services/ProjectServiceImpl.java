package com.hackathonpraktika.DevManagementSystem.services;

import com.hackathonpraktika.DevManagementSystem.repositories.PersonRepository;
import com.hackathonpraktika.DevManagementSystem.repositories.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectServiceImpl implements ProjectService{
    @Autowired
    private ProjectsRepository projectsRepository;

    public void deleteProjects(Long projectId){
        if (projectsRepository.existsById(projectId)){
            projectsRepository.deleteById(projectId);
        }else{
            throw new RuntimeException("Project not found with id: " + projectId);
        }
    }
}
