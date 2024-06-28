package com.hackathonpraktika.DevManagementSystem.services;

import com.hackathonpraktika.DevManagementSystem.model.Person;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService{

    //public List<Person> getPersonById(Long personId);

    public void deletePerson(Long personId);



}
