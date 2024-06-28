package com.hackathonpraktika.DevManagementSystem.services;

import com.hackathonpraktika.DevManagementSystem.dto.PersonDto;
import com.hackathonpraktika.DevManagementSystem.model.DevSkill;
import com.hackathonpraktika.DevManagementSystem.model.DevSkillExp;
import com.hackathonpraktika.DevManagementSystem.model.Person;
import com.hackathonpraktika.DevManagementSystem.repositories.DevSkillExpRepository;
import com.hackathonpraktika.DevManagementSystem.repositories.DevSkillRepository;
import com.hackathonpraktika.DevManagementSystem.repositories.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DevSkillExpRepository devSkillExpRepository;

    @Autowired
    private DevSkillRepository devSkillRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, DevSkillExpRepository devSkillExpRepository, DevSkillRepository devSkillRepository) {
        this.personRepository = personRepository;
        this.devSkillExpRepository = devSkillExpRepository;
        this.devSkillRepository = devSkillRepository;
    }


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
    @Override
    @Transactional
    public void addDeveloper(PersonDto personDto) {
        byte[] profilePictureBytes = null;
        if (personDto.getProfilePicture() != null) {
            try {
                profilePictureBytes = personDto.getProfilePicture().getBytes();
            } catch (IOException e) {
                throw new RuntimeException("Failed to read profile picture", e);
            }
        }

        Person person = new Person();
        person.setName(personDto.getName());
        person.setSurname(personDto.getSurname());
        person.setRole(personDto.getRole());
        person.setEmail(personDto.getEmail());
        person.setPassword(personDto.getPassword());
        person.setProfilePicture(profilePictureBytes);
        personRepository.save(person);

        processSkillsAndExperience(person.getPersonId(), personDto.getSkills(), personDto.getExperience());
    }

    @Override
    @Transactional
    public void updateDeveloper(Long id, PersonDto personDto) {
        Person person = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Developer not found"));

        person.setName(personDto.getName());
        person.setSurname(personDto.getSurname());
        person.setRole(personDto.getRole());
        person.setEmail(personDto.getEmail());
        person.setPassword(personDto.getPassword());
        if (personDto.getProfilePicture() != null) {
            try {
                person.setProfilePicture(personDto.getProfilePicture().getBytes());
            } catch (IOException e) {
                throw new RuntimeException("Failed to read profile picture", e);
            }
        }
        personRepository.save(person);

        // Delete existing skills and add new ones
        //devSkillExpRepository.deleteByPersonId(person.getPersonId());
        processSkillsAndExperience(person.getPersonId(), personDto.getSkills(), personDto.getExperience());
    }

    private void processSkillsAndExperience(Long personId, String skills, Integer experience) {
        String[] skillArray = skills.split(",");
        for (String skill : skillArray) {
            String trimmedSkill = skill.trim();
            DevSkill devSkill = devSkillRepository.findBySkillNameIgnoreCase(trimmedSkill);
            if (devSkill == null) {
                devSkill = new DevSkill();
                devSkill.setSkillName(trimmedSkill);
                devSkillRepository.save(devSkill);
            }

            DevSkillExp devSkillExp = new DevSkillExp();
            devSkillExp.setPersonId(personId);
            devSkillExp.setDevSkillId(devSkill.getDevSkillId());
            devSkillExp.setYearOfExp(experience);
            devSkillExpRepository.save(devSkillExp);
        }
    }
    @Override
    public void deletePerson(Long personId){
        if(personRepository.existsById(personId)){
            personRepository.deleteById(personId);
        }else{
            throw new RuntimeException("Person not found with id: " + personId );
        }
    }
}



