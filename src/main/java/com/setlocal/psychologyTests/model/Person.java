package com.setlocal.psychologyTests.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Person {

    public enum Role {
        ROLE_USER,
        ROLE_ADMIN
    }

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
    private boolean enabled;
    private LocalDateTime dateTime;
}
