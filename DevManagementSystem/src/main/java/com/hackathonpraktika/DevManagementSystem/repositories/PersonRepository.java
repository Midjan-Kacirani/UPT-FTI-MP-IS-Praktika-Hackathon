package com.hackathonpraktika.DevManagementSystem.repositories;

import com.hackathonpraktika.DevManagementSystem.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
