package com.setlocal.psychologyTests.util;

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
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if (personService.loadUserByUsername(person.getUsername()).isEmpty())
            return;
        errors.rejectValue("username", "", "Существует");
    }
}
