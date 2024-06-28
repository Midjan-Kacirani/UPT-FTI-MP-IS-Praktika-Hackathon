package com.hackathonpraktika.DevManagementSystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Person")
@Data
public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PersonId")
    private Long personId;


    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Surname", nullable = false)
    private String surname;

    @Column(name = "Role", nullable = false)
    private String role;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "profilePicture")
    private String profilePicture;

}

