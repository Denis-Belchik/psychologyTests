package com.setlocal.psychologyTests.service;

import com.setlocal.psychologyTests.dto.PersonForViewDTO;
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

    private final PersonRepository personRepository;;

    public List<PersonForViewDTO> getAllPersonDTO() {
        return personRepository.findAll().stream()
                .map(p -> new PersonForViewDTO().convertToDto(p))
                .collect(Collectors.toList());
    }

    public PersonForViewDTO showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof PersonDetails personDetails) {
            return new PersonForViewDTO().convertToDto(personDetails.getPerson());
        }
        return null;
    }

}
