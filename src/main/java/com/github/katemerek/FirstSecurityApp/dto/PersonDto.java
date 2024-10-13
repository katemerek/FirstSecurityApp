package com.github.katemerek.FirstSecurityApp.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

public class PersonDto {
    @NotBlank(message = "Необходимо ввести имя пользователя")
    @Size(min = 2, max = 30, message = "Имя должно быть от 2 до 30 символов длиной")
    private String username;

    @Min(value = 1900, message = "Человек должен быть моложе 1900 года рождения ")
    private int yearOfBirth;

    @NotBlank(message = "Необходимо ввести пароль")
    private String password;
}
