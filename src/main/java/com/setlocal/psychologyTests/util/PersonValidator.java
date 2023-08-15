package com.setlocal.psychologyTests.util;

import com.setlocal.psychologyTests.dto.PersonForRegDTO;
import com.setlocal.psychologyTests.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class PersonValidator implements Validator {

    private final AuthService authService;

    @Override
    public boolean supports(Class<?> clazz) {
        return PersonForRegDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PersonForRegDTO personForRegDTO = (PersonForRegDTO) target;
        if (authService.findByUsername(personForRegDTO.getUsername()).isPresent()) {
            errors.rejectValue("username", "",
                    "Такой пользователь уже существует");
        }
        if (!personForRegDTO.getPassword().equals(personForRegDTO.getConfirmPassword())) {
            errors.rejectValue("password", "", "Пароли не совпадают");
        }
    }
}
