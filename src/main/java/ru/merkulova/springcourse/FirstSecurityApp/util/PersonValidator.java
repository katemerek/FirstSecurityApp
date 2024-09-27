package ru.merkulova.springcourse.FirstSecurityApp.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.merkulova.springcourse.FirstSecurityApp.models.Person;
import ru.merkulova.springcourse.FirstSecurityApp.services.PersonDetailsService;

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
        personDetailsService.loadUserByUsername(person.getUsername());
      errors.rejectValue("username", "", "Человек с таким именем пользователя существует");
        }
    }
