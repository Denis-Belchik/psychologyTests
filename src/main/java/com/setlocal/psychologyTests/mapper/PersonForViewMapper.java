package com.setlocal.psychologyTests.mapper;

import com.setlocal.psychologyTests.dto.PersonForViewDTO;
import com.setlocal.psychologyTests.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonForViewMapper {

    public PersonForViewDTO mapToDto(Person person) {
        PersonForViewDTO personForViewDTO = new PersonForViewDTO();
        if (person != null) {
            personForViewDTO.setUsername(person.getUsername());
            personForViewDTO.setFirstName(person.getFirstName());
            personForViewDTO.setLastName(person.getLastName());
            personForViewDTO.setEmail(person.getEmail());
            personForViewDTO.setRole(person.getRole());
            personForViewDTO.setDateTime(person.getDateTime());
            personForViewDTO.setEnabled(person.isEnabled());
        }
        return personForViewDTO;
    }

}