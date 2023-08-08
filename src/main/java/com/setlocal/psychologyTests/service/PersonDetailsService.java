package com.setlocal.psychologyTests.service;

import com.setlocal.psychologyTests.dto.PersonDTO;
import com.setlocal.psychologyTests.model.Person;
import com.setlocal.psychologyTests.repository.PersonDao;
import com.setlocal.psychologyTests.security.PersonDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonDetailsService implements UserDetailsService {

    private final PersonDao personDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = personDao.findByUsername(username);
        if (person.isEmpty())
            throw new UsernameNotFoundException("Пользователь не найден");
        return new PersonDetails(PersonDTO.convertToDto(person.get()));
    }

}
