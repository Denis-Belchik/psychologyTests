package com.setlocal.psychologyTests.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {

    public enum Role {
        ROLE_USER,
        ROLE_ADMIN
    }

    private String username;
    private String lastName;
    private Role role;
    private String email;
    private String password;
    private boolean enabled;
}
