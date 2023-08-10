package com.setlocal.psychologyTests.dto;

import com.setlocal.psychologyTests.model.Person;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonForRegDTO {
    @Email(message = "Неправильный Email", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotEmpty(message = "EMail не должен быть пустым")
    private String email;

    @NotEmpty(message = "Имя не должно быть пустым")
    private String username;

    @NotEmpty(message = "Имя не должно быть пустым")
    private String firstName;

    @NotEmpty(message = "Фамилия не должна быть пустым")
    private String lastName;

    @NotEmpty(message = "Пароль не должен быть пустым")
    private String password;

    @NotEmpty(message = "Пароль не должен быть пустым")
    private String confirmPassword;

    private Person.Role role;

    private boolean enabled;

    private LocalDateTime dateTime;

    public static PersonForRegDTO convertToDto(Person person) {
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

    public static Person convertToEmpty(PersonForRegDTO personForRegDTO) {
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
