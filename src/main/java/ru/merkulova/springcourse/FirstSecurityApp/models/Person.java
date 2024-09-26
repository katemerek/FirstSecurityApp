package ru.merkulova.springcourse.FirstSecurityApp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   @NotEmpty(message = "Имя не должно быть пустым")
   @Size(min=2, max=30, message="имя должно быть от 2 до 30 символов длиной")
    @Column(name="username")
    private String username;
   @Min(value = 1900, message = "человек должен быть моложе 1900 года рождения ")
   @Column(name="year_of_birth")
   private int yearOfBirth;

   @Column(name="password")
   @Size(min=5, max=30, message="пароль должен быть от 2 до 30 символов")
   private String password;

}
