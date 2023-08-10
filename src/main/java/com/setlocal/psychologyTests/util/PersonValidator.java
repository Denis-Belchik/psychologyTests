package com.setlocal.psychologyTests.util;

import com.setlocal.psychologyTests.dto.PersonForRegDTO;
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
        return PersonForRegDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PersonForRegDTO personForRegDTO = (PersonForRegDTO) target;
        if (!personService.loadUserByUsername(personForRegDTO.getUsername()).isEmpty()) {
            errors.rejectValue("username", "", "Существует");
        }
        if (!personForRegDTO.getPassword().equals(personForRegDTO.getConfirmPassword())) {
            errors.rejectValue("password", "", "Разные");
        }
    }
}
