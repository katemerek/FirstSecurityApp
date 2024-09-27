package ru.merkulova.springcourse.FirstSecurityApp.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.merkulova.springcourse.FirstSecurityApp.models.Person;
import ru.merkulova.springcourse.FirstSecurityApp.repositories.PeopleRepository;

@Service
public class RegistrationSerice {

    private final PeopleRepository peopleRepository;
    public RegistrationSerice(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Transactional
    public void register(Person person){
        peopleRepository.save(person);
    }
}
