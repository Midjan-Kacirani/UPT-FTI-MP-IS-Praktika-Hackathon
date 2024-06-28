package com.hackathonpraktika.DevManagementSystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PersonDto {


    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(max = 100)
    private String surname;

    @NotBlank
    @Size(max = 50)
    private String role;

    @NotBlank
    @Email
    @Size(max = 100)
    private String email;

    private String skills;

    @NotNull
    private Integer experience;

    private String base64ProfilePicture;
}