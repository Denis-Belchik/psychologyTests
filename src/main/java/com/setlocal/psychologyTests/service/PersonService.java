package com.setlocal.psychologyTests.service;

import com.setlocal.psychologyTests.dto.PersonForRegDTO;
import com.setlocal.psychologyTests.dto.PersonForViewDTO;
import com.setlocal.psychologyTests.model.Person;
import com.setlocal.psychologyTests.repository.PersonDao;
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

    private final PersonDao personDao;
    private final PasswordEncoder passwordEncoder;

    public Optional<Person> loadUserByUsername(String username) {
        return personDao.findByUsername(username);
    }

    public Integer savePerson(PersonForRegDTO personForRegDTO) {
        Person person = PersonForRegDTO.convertToEmpty(personForRegDTO);
        String encoderPass = passwordEncoder.encode(person.getPassword());
        person.setPassword(encoderPass);
        person.setEnabled(true);
        person.setRole(Person.Role.ROLE_USER);
        person.setDateTime(LocalDateTime.now());
        return personDao.savePerson(person);
    }

    public List<PersonForViewDTO> getAllPerson(){
        return personDao.findAll().stream()
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
