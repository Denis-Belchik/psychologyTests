package com.setlocal.psychologyTests.service;

import com.setlocal.psychologyTests.dto.mainPage.MainPageForViewDTO;
import com.setlocal.psychologyTests.dto.mainPage.PersonForMainPageDTO;
import com.setlocal.psychologyTests.dto.mainPage.TestForMainPageDTO;
import com.setlocal.psychologyTests.mapper.MainPageForViewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("session")
@RequiredArgsConstructor
public class MainService {

    private final PersonService personService;
    private final QuestionService questionService;
    private final MainPageForViewMapper mainPageForViewMapper;

    public MainPageForViewDTO getMainContent(){
        PersonForMainPageDTO person = personService.getPersonForMainPage();
        List<TestForMainPageDTO> testList = questionService.getListTestForMain();
        return mainPageForViewMapper.mapToDTO(testList, person);
    }

}
