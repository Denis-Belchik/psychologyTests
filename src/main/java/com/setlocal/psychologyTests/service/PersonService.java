package com.setlocal.psychologyTests.service;

import com.setlocal.psychologyTests.model.Person;
import com.setlocal.psychologyTests.repository.PersonDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonDao personDao;

    public Optional<Person> loadUserByUsername(String username){
        return personDao.findByUsername(username);
    }

    public void savePerson(Person person){
        personDao.savePerson(person);
    }

}
