package com.setlocal.psychologyTests.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {
    private String email;
    private String username;
    private String lastName;
    private String password;
    private byte enabled;
}
