package com.setlocal.psychologyTests.repository;

import com.setlocal.psychologyTests.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class PersonDao {

    private final JdbcTemplate jdbcTemplate;

    private static final String FIND_PERSON_BY_NAME = """
            SELECT email,
                role,
                username,
                lastname,
                password,
                enabled
            FROM psychology_tests.person
            where username = ?
            """;

    private static final String SAVE_PERSON = """
            INSERT INTO psychology_tests.person(email, username, lastname, password, role, enabled) 
            VALUES (?, ?, ?, ?, cast(? as role), ?)    
            """;

    public Optional<Person> findByUsername(String username) {
        return jdbcTemplate.queryForStream(FIND_PERSON_BY_NAME, (rs, row) -> {
            Person person = new Person();
            person.setEmail(rs.getString("email"));
            person.setUsername(rs.getString("username"));
            person.setLastName(rs.getString("lastname"));
            person.setPassword(rs.getString("password"));
            person.setRole(Person.Role.valueOf(rs.getString("role")));
            person.setEnabled(rs.getBoolean("enabled"));
            return person;
        }, username).findAny();
    }

    public Integer savePerson(Person person) {
        return jdbcTemplate.update(SAVE_PERSON,
                person.getEmail(),
                person.getUsername(),
                person.getLastName(),
                person.getPassword(),
                person.getRole().name(),
                person.isEnabled());
    }

}
