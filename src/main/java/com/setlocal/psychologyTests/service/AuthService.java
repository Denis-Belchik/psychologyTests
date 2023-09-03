package com.setlocal.psychologyTests.service;

import com.setlocal.psychologyTests.dto.PersonForRegDTO;
import com.setlocal.psychologyTests.mapper.PersonForRegMapper;
import com.setlocal.psychologyTests.model.Person;
import com.setlocal.psychologyTests.repository.person.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;
    private final PersonForRegMapper personForRegMapper;

    public Optional<Person> findByUsername(String username) {
        return personRepository.findByUsername(username);
    }

    public Person savePerson(PersonForRegDTO personForRegDTO) {
        Person person = personForRegMapper.mapToEmpty(personForRegDTO);
        String encoderPass = passwordEncoder.encode(person.getPassword());
        person.setPassword(encoderPass);
        person.setEnabled(true);
        person.setRole(Person.Role.ROLE_USER);
        person.setDateTime(LocalDateTime.now());
        return personRepository.save(person);
    }
}
