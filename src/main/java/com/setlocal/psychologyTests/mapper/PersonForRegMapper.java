package com.setlocal.psychologyTests.mapper;

import com.setlocal.psychologyTests.dto.PersonForRegDTO;
import com.setlocal.psychologyTests.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonForRegMapper {

    public PersonForRegDTO mapToDto(Person person) {
        PersonForRegDTO personForRegDto = new PersonForRegDTO();
        if (person != null) {
            personForRegDto.setUsername(person.getUsername());
            personForRegDto.setFirstName(person.getFirstName());
            personForRegDto.setLastName(person.getLastName());
            personForRegDto.setEmail(person.getEmail());
            personForRegDto.setPassword(person.getPassword());
            personForRegDto.setEnabled(person.isEnabled());
            personForRegDto.setRole(person.getRole());
            personForRegDto.setDateTime(person.getDateTime());
        }
        return personForRegDto;
    }

    public Person mapToEmpty(PersonForRegDTO personForRegDTO) {
        Person person = new Person();
        if (personForRegDTO != null) {
            person.setUsername(personForRegDTO.getUsername());
            person.setFirstName(personForRegDTO.getFirstName());
            person.setLastName(personForRegDTO.getLastName());
            person.setEmail(personForRegDTO.getEmail());
            person.setPassword(personForRegDTO.getPassword());
            person.setEnabled(personForRegDTO.isEnabled());
            person.setRole(personForRegDTO.getRole());
            person.setDateTime(personForRegDTO.getDateTime());
        }
        return person;
    }

}