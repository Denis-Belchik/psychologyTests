package com.setlocal.psychologyTests.model;

import lombok.Data;

@Data
public class Person {
    private String username;
    private String password;
    private byte enabled;
}
