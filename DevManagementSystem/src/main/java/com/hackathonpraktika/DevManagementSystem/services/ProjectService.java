package com.hackathonpraktika.DevManagementSystem.services;

import com.hackathonpraktika.DevManagementSystem.model.Projects;
import org.springframework.stereotype.Service;

public interface ProjectService {
    public void deleteProjects(Long projectId);

}
