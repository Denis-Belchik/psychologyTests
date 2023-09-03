package com.setlocal.psychologyTests.dto;

import com.setlocal.psychologyTests.model.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PersonForViewDTO {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Person.Role role;
    private LocalDateTime dateTime;
    private boolean enabled;

}