package com.setlocal.psychologyTests.service;

import com.setlocal.psychologyTests.dto.ViewTestDTO;
import com.setlocal.psychologyTests.dto.model.QuestionDTO;
import com.setlocal.psychologyTests.dto.model.TestDTO;
import com.setlocal.psychologyTests.dto.mainPage.TestForMainPageDTO;
import com.setlocal.psychologyTests.mapper.TestForMainPageMapper;
import com.setlocal.psychologyTests.mapper.ViewTestMapper;
import com.setlocal.psychologyTests.model.Question;
import com.setlocal.psychologyTests.model.Test;
import com.setlocal.psychologyTests.repository.test.TestRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Service
@Scope("session")
@RequiredArgsConstructor
public class QuestionService {

    private int position = 0;
    private boolean isRun = false;
    private TestDTO testDto;

    private final TestRepository testRepository;
    private final TestForMainPageMapper testForMainPageMapper;
    private final ViewTestMapper viewTestMapper;

    public ViewTestDTO getViewTest(){
        return viewTestMapper.mapToDTO(getQuestion().getBody(),
                getPosition(),
                getTestTitle(),
                getTestSize(),
                getQuestion().getAnswers(),
                getQuestionType());
    }

    public void testRun(int id) {
        Test test = testRepository.findById(id).orElse(null);
        testDto =  new TestDTO().convertToDto(test);
        System.out.println(testDto);
        if (testDto.getSize() > 0) {
            isRun = true;
        } else {
            testStop();
        }
    }

    public void testStop() {
        position = 0;
        testDto = null;
    }

    public void nextPosition() {
        if (position < testDto.getSize())
            position++;
    }

    public void prefPosition() {
        if (position > 0)
            position--;
    }

    public QuestionDTO getQuestion() {
        if (testDto.getSize() > position)
            return testDto.getQuestions().get(position);
        return null;
    }

    public Question.TypeAnswer getQuestionType() {
        return testDto.getQuestions().get(position).getType();
    }

    public String getTestTitle() {
        return testDto.getTitle();
    }

    public Integer getTestSize() {
        return testDto.getSize();
    }

    public List<TestForMainPageDTO> getListTestForMain() {
        return testRepository.findAll().stream()
                .map(testForMainPageMapper::mapToDTO)
                .collect(Collectors.toList());
    }
}