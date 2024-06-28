package com.hackathonpraktika.DevManagementSystem.controllers;

import com.hackathonpraktika.DevManagementSystem.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    private PersonService  personService;

    @DeleteMapping("{/id}")
    public ResponseEntity<Void> deleteProjects(@PathVariable(value = "id") Long personId){
        personService.deletePerson(personId);
        return ResponseEntity.noContent().build();
    }
}
