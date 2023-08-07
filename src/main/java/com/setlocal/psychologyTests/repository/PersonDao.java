package com.setlocal.psychologyTests.repository;

import com.setlocal.psychologyTests.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class PersonDao {

    private final JdbcTemplate jdbcTemplate;

    private static final String FIND_PERSON_BY_NAME = """
            SELECT username,
                password,
                enabled
            FROM psychology_tests.person
            where username = ?
            """;

    private static final String SAVE_PERSON = """
            INSERT INTO psychology_tests.person(username, password, enabled) 
            VALUES (?, ? , 1)    
            """;

    public Optional<Person> findByUsername(String username) {
        return jdbcTemplate.queryForStream(FIND_PERSON_BY_NAME, (rs, row) -> {
            Person person = new Person();
            person.setUsername(rs.getString("username"));
            person.setPassword(rs.getString("password"));
            person.setEnabled(rs.getByte("enabled"));
            return person;
        }, username).findAny();
    }

    public Integer savePerson(Person person){
        return jdbcTemplate.update(SAVE_PERSON, person.getUsername(), person.getPassword());
    }

}
