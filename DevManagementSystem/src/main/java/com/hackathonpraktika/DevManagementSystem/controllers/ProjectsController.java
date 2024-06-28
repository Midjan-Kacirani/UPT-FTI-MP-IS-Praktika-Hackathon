package com.hackathonpraktika.DevManagementSystem.controllers;

import com.hackathonpraktika.DevManagementSystem.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectsController {

    @Autowired
    private ProjectService projectService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjects(@PathVariable Long id) {
        projectService.deleteProjects(id);
        return ResponseEntity.noContent().build();
    }

}
