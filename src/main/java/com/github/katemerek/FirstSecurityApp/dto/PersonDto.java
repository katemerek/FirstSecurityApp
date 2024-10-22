package com.github.katemerek.FirstSecurityApp.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    @NotBlank(message = "Необходимо ввести имя пользователя")
    @Size(min = 2, max = 30, message = "Имя должно быть от 2 до 30 символов длиной")
    private String username;

    @Min(value = 1900, message = "Человек должен быть моложе 1900 года рождения ")
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @NotBlank(message = "Необходимо ввести пароль")
    private String password;

}
