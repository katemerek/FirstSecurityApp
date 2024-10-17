package com.github.katemerek.FirstSecurityApp.util;


import com.github.katemerek.FirstSecurityApp.models.Person;
import com.github.katemerek.FirstSecurityApp.services.PersonDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private final PersonDetailsService personDetailsService;

    public PersonValidator(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if (personDetailsService.findByUserName(person.getUsername()).isPresent())
            errors.rejectValue("username", String.valueOf(HttpStatus.BAD_REQUEST), "Человек с таким именем уже есть в базе данных!");
    }
}

