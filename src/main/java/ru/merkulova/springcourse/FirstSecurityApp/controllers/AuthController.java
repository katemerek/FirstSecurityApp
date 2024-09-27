package ru.merkulova.springcourse.FirstSecurityApp.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.merkulova.springcourse.FirstSecurityApp.models.Person;
import ru.merkulova.springcourse.FirstSecurityApp.services.RegistrationSerice;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final RegistrationSerice registrationSerice;

    public AuthController(RegistrationSerice registrationSerice) {
        this.registrationSerice = registrationSerice;
    }


    @GetMapping("/login")
    private String login (){
        return "login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("Person") Person person){
        return "registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("Person") @Valid Person person, BindingResult result){
        if (result.hasErrors()) {
            return "/registration";
        }
        registrationSerice.register(person);

        return "redirect:/auth/login";
    }
}
