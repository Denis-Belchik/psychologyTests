package com.setlocal.psychologyTests.mapper;

import com.setlocal.psychologyTests.dto.mainPage.MainPageForViewDTO;
import com.setlocal.psychologyTests.dto.mainPage.PersonForMainPageDTO;
import com.setlocal.psychologyTests.dto.mainPage.TestForMainPageDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MainPageForViewMapper {

    public MainPageForViewDTO mapToDTO(List<TestForMainPageDTO> testList, PersonForMainPageDTO person){
        MainPageForViewDTO mainPageForViewDTO = new MainPageForViewDTO();
        mainPageForViewDTO.setPersonForMainPageDTO(person);
        mainPageForViewDTO.setTestForMainPageDTOList(testList);
        return mainPageForViewDTO;
    }

}
