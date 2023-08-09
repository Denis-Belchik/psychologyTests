package com.setlocal.psychologyTests.dto;

import com.setlocal.psychologyTests.model.Person;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    @Email(message = "Неправильный Email", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotEmpty(message = "EMail не должен быть пустым")
    private String email;
    @NotEmpty(message = "Имя не должно быть пустым")
    private String username;
    @NotEmpty(message = "Фамилия не должна быть пустым")
    private String lastName;
    @NotEmpty(message = "Пароль не должен быть пустым")
    private String password;
    @NotEmpty(message = "Пароль не должен быть пустым")
    private String confirmPassword;
    private Person.Role role;
    private boolean enabled;

    public static PersonDTO convertToDto(Person person) {
        PersonDTO personDto = new PersonDTO();
        if (person != null) {
            personDto.setEmail(person.getEmail());
            personDto.setRole(person.getRole());
            personDto.setUsername(person.getUsername());
            personDto.setLastName(person.getLastName());
            personDto.setPassword(person.getPassword());
            personDto.setEnabled(person.isEnabled());
        }
        return personDto;
    }

    public static Person convertToEmpty(PersonDTO personDTO) {
        Person person = new Person();
        if (personDTO != null) {
            person.setEmail(personDTO.getEmail());
            person.setRole(personDTO.getRole());
            person.setUsername(personDTO.getUsername());
            person.setLastName(personDTO.getLastName());
            person.setPassword(personDTO.getPassword());
            person.setEnabled(personDTO.isEnabled());
        }
        return person;
    }

}
