package com.setlocal.psychologyTests.controller;

import com.setlocal.psychologyTests.dto.PersonForRegDTO;
import com.setlocal.psychologyTests.service.AuthService;
import com.setlocal.psychologyTests.util.PersonValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("session")
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final PersonValidator personValidator;

    @GetMapping("/login")
    public String login(@ModelAttribute("error") String error) {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPages(@ModelAttribute("personForRegDTO") PersonForRegDTO personForRegDTO) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("personForRegDTO") @Valid PersonForRegDTO personForRegDTO,
                               BindingResult bindingResult) {
        personValidator.validate(personForRegDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/auth/registration";
        }
        if (authService.savePerson(personForRegDTO) != null)
            return "/auth/login";
        return "/auth/registration";
    }

}
