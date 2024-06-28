package com.hackathonpraktika.DevManagementSystem.services;

import com.hackathonpraktika.DevManagementSystem.model.Person;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService{

    List<Person> searchPersonsByName(String name);
    List<Person> searchPersonsBySkill(String skillName);
    List<Person> searchPersonsByExperience(int experience);
    List<Person> searchPersonsBySkillAndExperience(String skillName, int experience);
    void deletePerson(Long personId);
}
