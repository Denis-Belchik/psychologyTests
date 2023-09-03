package com.setlocal.psychologyTests.service;

import com.setlocal.psychologyTests.dto.mainPage.PersonForMainPageDTO;
import com.setlocal.psychologyTests.dto.PersonForViewDTO;
import com.setlocal.psychologyTests.mapper.PersonForMainPageMapper;
import com.setlocal.psychologyTests.mapper.PersonForViewMapper;
import com.setlocal.psychologyTests.model.Person;
import com.setlocal.psychologyTests.repository.person.PersonRepository;
import com.setlocal.psychologyTests.security.PersonDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonForMainPageMapper personForMainPageMapper;
    private final PersonForViewMapper personForViewMapper;

    public List<PersonForViewDTO> getAllPersonForView() {
        return personRepository.findAll().stream()
                .map(personForViewMapper::mapToDto)
                .collect(Collectors.toList());
    }

    private Person showAuthPerson() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof PersonDetails personDetails) {
            return personDetails.getPerson();
        }
        return null;
    }

    public PersonForMainPageDTO getPersonForMainPage() {
        PersonForMainPageDTO personForMainPageDTO = new PersonForMainPageDTO();
        Person person = showAuthPerson();
        if (person != null) {
            personForMainPageDTO = personForMainPageMapper.mapToDTO(person);
        }
        return personForMainPageDTO;
    }


}
