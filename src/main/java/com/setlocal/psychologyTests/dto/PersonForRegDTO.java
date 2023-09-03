package com.setlocal.psychologyTests.dto;

import com.setlocal.psychologyTests.model.Person;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
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

}