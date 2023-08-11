package com.setlocal.psychologyTests.repository;

import com.setlocal.psychologyTests.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {

    Optional<Person> findByUsername(String username);
    Person save(Person person);
    List<Person> findAll();

}
