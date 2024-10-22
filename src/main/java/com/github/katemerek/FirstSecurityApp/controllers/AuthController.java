package com.github.katemerek.FirstSecurityApp.controllers;

import com.github.katemerek.FirstSecurityApp.dto.PersonDto;
import com.github.katemerek.FirstSecurityApp.mapper.PersonMapper;
import com.github.katemerek.FirstSecurityApp.models.Person;
import com.github.katemerek.FirstSecurityApp.services.RegistrationService;
import com.github.katemerek.FirstSecurityApp.util.ErrorsUtil;
import com.github.katemerek.FirstSecurityApp.util.PersonValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController{

    private final RegistrationService registrationService;
    private final PersonValidator personValidator;
    private final PersonMapper personMapper;

    @GetMapping("/login")
    private String login (){
        return "login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") PersonDto personDto){
        return "registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("Person") @Valid PersonDto personDto, BindingResult result){
        Person personAdd = personMapper.toPerson(personDto);
        personValidator.validate(personAdd, result);
        if (result.hasErrors()) {
            ErrorsUtil.returnError(result);
        }
        registrationService.register(personAdd);
        return "redirect:/auth/login";
    }
}
