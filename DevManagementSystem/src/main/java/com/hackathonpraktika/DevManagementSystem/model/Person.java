package com.hackathonpraktika.DevManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity
@Table(name = "Person")
@Data
public class Person {

/*
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

 */


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "PersonId")
        private Long personId;

        @NotBlank
        @Size(max = 100)
        @Column(name = "Name", nullable = false)
        private String name;

        @NotBlank
        @Size(max = 100)
        @Column(name = "Surname", nullable = false)
        private String surname;

        @NotBlank
        @Size(max = 50)
        @Column(name = "Role", nullable = false)
        private String role;

        @NotBlank
        @Email
        @Size(max = 100)
        @Column(name = "Email", nullable = false, unique = true)
        private String email;

        @NotBlank
        @Size(max = 255)
        @Column(name = "Password", nullable = false)
        private String password;

        @Lob
        @Column(name = "profilePicture")
        private byte[] profilePicture;
}


