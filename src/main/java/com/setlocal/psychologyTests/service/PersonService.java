package com.setlocal.psychologyTests.service;

import com.setlocal.psychologyTests.dto.PersonDTO;
import com.setlocal.psychologyTests.model.Person;
import com.setlocal.psychologyTests.repository.PersonDao;
import com.setlocal.psychologyTests.security.PersonDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonDao personDao;
    private final PasswordEncoder passwordEncoder;

    public Optional<Person> loadUserByUsername(String username) {
        return personDao.findByUsername(username);
    }

    public Integer savePerson(PersonDTO personDTO) {
        Person person = PersonDTO.convertToEmpty(personDTO);
        String encoderPass = passwordEncoder.encode(person.getPassword());
        person.setPassword(encoderPass);
        person.setEnabled(true);
        person.setRole(Person.Role.ROLE_USER);
        return personDao.savePerson(person);
    }

    public PersonDTO showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof PersonDetails personDetails) {
            return personDetails.getPersonDTO();
        }
        return null;
    }

}
