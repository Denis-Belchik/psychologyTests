package com.setlocal.psychologyTests.dto;

import com.setlocal.psychologyTests.model.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PersonForViewDTO {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Person.Role role;
    private LocalDateTime dateTime;
    private boolean enabled;

    public static PersonForViewDTO convertToDto(Person person) {
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
