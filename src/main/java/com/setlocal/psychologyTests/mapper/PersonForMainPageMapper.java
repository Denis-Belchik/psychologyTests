package com.setlocal.psychologyTests.mapper;

import com.setlocal.psychologyTests.dto.mainPage.PersonForMainPageDTO;
import com.setlocal.psychologyTests.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonForMainPageMapper {

    public PersonForMainPageDTO mapToDTO(Person person) {
        PersonForMainPageDTO personForMainPageDTO = new PersonForMainPageDTO();
        personForMainPageDTO.setFirstName(person.getFirstName());
        personForMainPageDTO.setLastName(person.getLastName());
        return personForMainPageDTO;
    }

}
