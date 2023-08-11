package com.setlocal.psychologyTests.service;

import com.setlocal.psychologyTests.dto.PersonForRegDTO;
import com.setlocal.psychologyTests.dto.PersonForViewDTO;
import com.setlocal.psychologyTests.model.Person;
import com.setlocal.psychologyTests.repository.PersonRepository;
import com.setlocal.psychologyTests.security.PersonDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    public Optional<Person> loadUserByUsername(String username) {
        return personRepository.findByUsername(username);
    }

    public Person savePerson(PersonForRegDTO personForRegDTO) {
        Person person = PersonForRegDTO.convertToEmpty(personForRegDTO);
        String encoderPass = passwordEncoder.encode(person.getPassword());
        person.setPassword(encoderPass);
        person.setEnabled(true);
        person.setRole(Person.Role.ROLE_USER);
        person.setDateTime(LocalDateTime.now());
        return personRepository.save(person);
    }

    public List<PersonForViewDTO> getAllPerson(){
        return personRepository.findAll().stream()
                .map(PersonForViewDTO::convertToDto)
                .collect(Collectors.toList());
    }

    public PersonForViewDTO showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof PersonDetails personDetails) {
            return PersonForViewDTO.convertToDto(personDetails.getPerson());
        }
        return null;
    }

}
