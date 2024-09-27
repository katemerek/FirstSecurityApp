package ru.merkulova.springcourse.FirstSecurityApp.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.merkulova.springcourse.FirstSecurityApp.models.Person;
import ru.merkulova.springcourse.FirstSecurityApp.services.RegistrationService;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final RegistrationService registrationService;

    public AuthController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/login")
    private String login (){
        return "login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Person person){
        return "registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("Person") @Valid Person person, BindingResult result){
        if (result.hasErrors()) {
            return "/registration";
        }
        registrationService.register(person);

        return "redirect:/auth/login";
    }
}
