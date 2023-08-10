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
            SELECT username,
                firstname,
                lastname,
                email,
                password,
                role,
                enabled,
                date_time
            FROM psychology_tests.person
            where username = ?
            """;

    private static final String SAVE_PERSON = """
            INSERT INTO psychology_tests.person(
                username, firstname, lastname, email, password, role, enabled, date_time) 
            VALUES (?, ?, ?, ?, ?, cast(? as role), ?, ?)    
            """;

    public Optional<Person> findByUsername(String username) {
        return jdbcTemplate.queryForStream(FIND_PERSON_BY_NAME, (rs, row) -> {
            Person person = new Person();
            person.setUsername(rs.getString("username"));
            person.setLastName(rs.getString("lastname"));
            person.setFirstName(rs.getString("firstname"));
            person.setEmail(rs.getString("email"));
            person.setPassword(rs.getString("password"));
            person.setRole(Person.Role.valueOf(rs.getString("role")));
            person.setEnabled(rs.getBoolean("enabled"));
            person.setDateTime(rs.getTimestamp("date_time").toLocalDateTime());
            return person;
        }, username).findAny();
    }

    public Integer savePerson(Person person) {
        return jdbcTemplate.update(SAVE_PERSON,
                person.getUsername(),
                person.getFirstName(),
                person.getLastName(),
                person.getEmail(),
                person.getPassword(),
                person.getRole().name(),
                person.isEnabled(),
                person.getDateTime());
    }

}
