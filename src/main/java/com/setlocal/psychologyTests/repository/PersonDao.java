package com.setlocal.psychologyTests.repository;

import com.setlocal.psychologyTests.dto.PersonForViewDTO;
import com.setlocal.psychologyTests.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class PersonDao {

    private final JdbcTemplate jdbcTemplate;

    private static final String FIND_PERSON_BY_NAME_SQL = """
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

    private static final String SAVE_PERSON_SQL = """
            INSERT INTO psychology_tests.person(
                username, firstname, lastname, email, password, role, enabled, date_time) 
            VALUES (?, ?, ?, ?, ?, cast(? as role), ?, ?)    
            """;

    private static final String ALL_PERSON_SQL = """
            SELECT username,
                firstname,
                lastname,
                email,
                password,
                role,
                enabled,
                date_time
            FROM psychology_tests.person
            """;

    public Optional<Person> findByUsername(String username) {
        return jdbcTemplate.queryForStream(FIND_PERSON_BY_NAME_SQL, (rs, row) -> {
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
                },
                username).findAny();
    }

    public Integer savePerson(Person person) {
        return jdbcTemplate.update(SAVE_PERSON_SQL,
                person.getUsername(),
                person.getFirstName(),
                person.getLastName(),
                person.getEmail(),
                person.getPassword(),
                person.getRole().name(),
                person.isEnabled(),
                person.getDateTime());
    }

    public List<Person> findAll() {
        return jdbcTemplate.query(ALL_PERSON_SQL, (rs, rowNum) -> {
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
                }
        );
    }
}
