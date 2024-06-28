package com.hackathonpraktika.DevManagementSystem.controllers;

import com.hackathonpraktika.DevManagementSystem.dto.PersonDto;
import com.hackathonpraktika.DevManagementSystem.model.DevSkill;
import com.hackathonpraktika.DevManagementSystem.model.DevSkillExp;
import com.hackathonpraktika.DevManagementSystem.model.Person;
import com.hackathonpraktika.DevManagementSystem.repositories.DevSkillExpRepository;
import com.hackathonpraktika.DevManagementSystem.repositories.DevSkillRepository;
import com.hackathonpraktika.DevManagementSystem.repositories.PersonRepository;
import com.hackathonpraktika.DevManagementSystem.services.PersonService;
import com.hackathonpraktika.DevManagementSystem.services.PersonServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController("/developers")
public class DeveloperController {

    @Autowired
 private PersonServiceImpl personServiceImpl;

    @PostMapping("/addDeveloper")
    public ResponseEntity<String> addDeveloper(@Valid @ModelAttribute PersonDto personDto) {
        personServiceImpl.addDeveloper(personDto);
        return ResponseEntity.ok("Developer profile added successfully");
    }

    @PutMapping("/updateDeveloper/{id}")
    public ResponseEntity<String> updateDeveloper(@PathVariable Long id, @Valid @ModelAttribute PersonDto personDto) {
        personServiceImpl.updateDeveloper(id, personDto);
        return ResponseEntity.ok("Developer profile updated successfully");
    }
}

