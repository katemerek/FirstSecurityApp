package com.github.katemerek.FirstSecurityApp.controllers;

import com.github.katemerek.FirstSecurityApp.dto.PersonDto;
import com.github.katemerek.FirstSecurityApp.models.Person;
import com.github.katemerek.FirstSecurityApp.services.RegistrationService;
import com.github.katemerek.FirstSecurityApp.util.ErrorResponse;
import com.github.katemerek.FirstSecurityApp.util.ErrorsUtil;
import com.github.katemerek.FirstSecurityApp.util.PersonNotCreated;
import com.github.katemerek.FirstSecurityApp.util.PersonValidator;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final RegistrationService registrationService;
    private final PersonValidator personValidator;
    private final ModelMapper modelMapper;
    public AuthController(RegistrationService registrationService, PersonValidator personValidator, ModelMapper modelMapper) {
        this.registrationService = registrationService;
        this.personValidator = personValidator;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    private String login (){
        return "login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person")PersonDto personDto){
        return "registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("Person") @Valid PersonDto personDto, BindingResult result){
        Person personAdd = modelMapper.map(personDto, Person.class);
        personValidator.validate(personAdd, result);
        if (result.hasErrors()) {
            ErrorsUtil.returnError(result);
        }
        registrationService.register(personAdd);
        return "redirect:/auth/login";
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleSensorNotCreatedException(PersonNotCreated e) {
        com.github.katemerek.FirstSecurityApp.util.ErrorResponse response = new ErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
