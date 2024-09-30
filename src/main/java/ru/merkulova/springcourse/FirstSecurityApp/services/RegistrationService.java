package ru.merkulova.springcourse.FirstSecurityApp.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.merkulova.springcourse.FirstSecurityApp.models.Person;
import ru.merkulova.springcourse.FirstSecurityApp.repositories.PeopleRepository;

@Service
public class RegistrationService {

    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder) {
        this.peopleRepository = peopleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(Person person){
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole(("ROLE_USER"));
        peopleRepository.save(person);
    }
}
