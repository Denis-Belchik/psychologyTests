package com.setlocal.psychologyTests.repository;

import com.setlocal.psychologyTests.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


//@Primary
@RequiredArgsConstructor
@Repository
public class PersonDaoImpl implements PersonRepository {

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
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)    
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

    @Override
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

    @Override
    public Person save(Person person) {
        jdbcTemplate.update(SAVE_PERSON_SQL,
                person.getUsername(),
                person.getFirstName(),
                person.getLastName(),
                person.getEmail(),
                person.getPassword(),
                person.getRole().name(),
                person.isEnabled(),
                person.getDateTime()
        );
        return person;
    }

    @Override
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