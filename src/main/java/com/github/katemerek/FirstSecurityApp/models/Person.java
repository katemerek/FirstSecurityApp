package com.github.katemerek.FirstSecurityApp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "Person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Необходимо ввести имя пользователя")
    @Size(min = 2, max = 30, message = "Имя должно быть от 2 до 30 символов длиной")
    @Column(name = "username")
    private String username;

    @Min(value = 1900, message = "Человек должен быть моложе 1900 года рождения ")
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @NotBlank(message = "Необходимо ввести пароль")
    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;
}
