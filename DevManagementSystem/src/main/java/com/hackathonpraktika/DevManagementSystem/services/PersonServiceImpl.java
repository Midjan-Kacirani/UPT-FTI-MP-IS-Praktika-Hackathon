package com.hackathonpraktika.DevManagementSystem.services;

import com.hackathonpraktika.DevManagementSystem.model.DevSkillExp;
import com.hackathonpraktika.DevManagementSystem.model.Person;
import com.hackathonpraktika.DevManagementSystem.repositories.DevSkillExpRepository;
import com.hackathonpraktika.DevManagementSystem.repositories.DevSkillRepository;
import com.hackathonpraktika.DevManagementSystem.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DevSkillExpRepository devSkillExpRepository;

    @Autowired
    private DevSkillRepository devSkillRepository;


    @Override
    public List<Person> searchPersonsByName(String name) {
         return personRepository.findByNameIgnoreCase(name);
    }

    @Override
    public List<Person> searchPersonsBySkill(String skillName) {
        List<DevSkillExp> devSkillExps = devSkillExpRepository.findBySkillName(skillName);
        return devSkillExps.stream()
                .map(DevSkillExp::getPerson)
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> searchPersonsByExperience(int experience) {
        return personRepository.findByExperience(experience);
    }

    @Override
    public List<Person> searchPersonsBySkillAndExperience(String skillName, int experience) {
        List<DevSkillExp> devSkillExps = devSkillExpRepository.findBySkillAndExperience(skillName, experience);
        return devSkillExps.stream()
                .map(DevSkillExp::getPerson)
                .collect(Collectors.toList());
    }
}
