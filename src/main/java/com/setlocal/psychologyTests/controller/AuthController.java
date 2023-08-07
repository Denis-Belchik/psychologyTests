package com.setlocal.psychologyTests.controller;

import com.setlocal.psychologyTests.model.Person;
import com.setlocal.psychologyTests.service.PersonService;
import com.setlocal.psychologyTests.util.PersonValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final PersonService personService;
    private final PersonValidator personValidator;

    @GetMapping("/login")
    public String login(@ModelAttribute("error") String error) {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPages(@ModelAttribute("person") Person person) {

        return "auth/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("person") @Valid Person person,
                               BindingResult bindingResult) {
        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors())
            return "/auth/registration";
        personService.savePerson(person);
        return "/auth/login";
    }

}
