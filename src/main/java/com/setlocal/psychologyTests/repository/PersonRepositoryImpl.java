package com.setlocal.psychologyTests.repository;

import com.setlocal.psychologyTests.model.Person;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface PersonRepositoryImpl extends PersonRepository, JpaRepository<Person, Integer> {
}
