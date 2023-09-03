package com.setlocal.psychologyTests.service;

import com.setlocal.psychologyTests.dto.ViewTestDTO;
import com.setlocal.psychologyTests.dto.model.AnswerDTO;
import com.setlocal.psychologyTests.dto.model.QuestionDTO;
import com.setlocal.psychologyTests.dto.model.TestDTO;
import com.setlocal.psychologyTests.dto.mainPage.TestForMainPageDTO;
import com.setlocal.psychologyTests.exception.TestNotFoundException;
import com.setlocal.psychologyTests.mapper.TestForMainPageMapper;
import com.setlocal.psychologyTests.mapper.model.TestMapper;
import com.setlocal.psychologyTests.mapper.ViewTestMapper;
import com.setlocal.psychologyTests.model.Question;
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
    private TestDTO testDTO;

    private final TestRepository testRepository;
    private final TestForMainPageMapper testForMainPageMapper;
    private final ViewTestMapper viewTestMapper;
    private final TestMapper testMapper;

    public ViewTestDTO getViewTest() {
        return viewTestMapper.mapToDTO(
                getQuestion().getId(),
                testDTO.getId(),
                getQuestion().getBody(),
                getPosition(),
                getTestTitle(),
                getTestSize(),
                getAnswers(),
                getQuestionType());
    }

    public void testRun(int id) {
        testDTO = testRepository.findById(id)
                .map(testMapper::mapToDto)
                .orElseThrow(() -> new TestNotFoundException("Не найден тест = " + id));
        isRun = true;
    }

    public void testStop() {
        position = 0;
        testDTO = null;
    }

    public void nextPosition() {
        if (position < testDTO.getSize())
            position++;
    }

    public void prefPosition() {
        if (position > 0)
            position--;
    }

    public QuestionDTO getQuestion() {
        if (testDTO.getSize() > position)
            return testDTO.getQuestions().get(position);
        return null;
    }

    public List<AnswerDTO> getAnswers() {
        if (testDTO.getSize() > position)
            return testDTO.getQuestions().get(position).getAnswers();
        return null;
    }

    public Question.TypeAnswer getQuestionType() {
        return testDTO.getQuestions().get(position).getType();
    }

    public String getTestTitle() {
        return testDTO.getTitle();
    }

    public Integer getTestSize() {
        return testDTO.getSize();
    }

    public List<TestForMainPageDTO> getListTestForMain() {
        return testRepository.findAll().stream()
                .map(testForMainPageMapper::mapToDTO)
                .collect(Collectors.toList());
    }
}