package com.setlocal.psychologyTests.util;

import com.setlocal.psychologyTests.dto.PersonDTO;
import com.setlocal.psychologyTests.model.Person;
import com.setlocal.psychologyTests.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class PersonValidator implements Validator {

    private final PersonService personService;

    @Override
    public boolean supports(Class<?> clazz) {
        return PersonDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PersonDTO personDTO = (PersonDTO) target;
        if (!personService.loadUserByUsername(personDTO.getUsername()).isEmpty()) {
            errors.rejectValue("username", "", "Существует");
        }
        if (!personDTO.getPassword().equals(personDTO.getConfirmPassword())) {
            errors.rejectValue("password", "", "Разные");
        }
    }
}
