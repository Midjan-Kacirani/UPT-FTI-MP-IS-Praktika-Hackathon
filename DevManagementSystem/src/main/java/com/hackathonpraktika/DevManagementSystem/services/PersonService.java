package com.hackathonpraktika.DevManagementSystem.services;

import com.hackathonpraktika.DevManagementSystem.model.Person;

import java.util.List;

public interface PersonService{

    List<Person> searchPersonsByName(String name);
    List<Person> searchPersonsBySkill(String skillName);
    List<Person> searchPersonsByExperience(int experience);
    List<Person> searchPersonsBySkillAndExperience(String skillName, int experience);

}
