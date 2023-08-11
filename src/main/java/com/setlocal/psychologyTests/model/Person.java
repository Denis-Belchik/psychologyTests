package com.setlocal.psychologyTests.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name="person", schema="psychology_tests")
public class Person {

    public enum Role {
        ROLE_USER,
        ROLE_ADMIN
    }

    @Id
    private String username;

    @Column(name="firstname")
    private String firstName;

    @Column(name="lastname")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name="enabled")
    private boolean enabled;

    @Column(name="date_time")
    private LocalDateTime dateTime;
}
