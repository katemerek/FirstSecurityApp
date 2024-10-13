package com.github.katemerek.FirstSecurityApp.controllers;

import com.github.katemerek.FirstSecurityApp.models.Person;
import com.github.katemerek.FirstSecurityApp.services.RegistrationService;
import com.github.katemerek.FirstSecurityApp.util.PersonValidator;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final RegistrationService registrationService;
    private final PersonValidator personValidator;
    public AuthController(RegistrationService registrationService, PersonValidator personValidator) {
        this.registrationService = registrationService;
        this.personValidator = personValidator;
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
        personValidator.validate(person, result);
        if (result.hasErrors()) {
            return "/registration";
        }
        registrationService.register(person);
        return "redirect:/auth/login";
    }
}
