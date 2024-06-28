package com.hackathonpraktika.DevManagementSystem.services;

import com.hackathonpraktika.DevManagementSystem.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;


    public void deletePerson(Long personId){
        if(personRepository.existsById(personId)){
            personRepository.deleteById(personId);
        }else{
            throw new RuntimeException("Person not found with id: " + personId );
        }
    }





}
