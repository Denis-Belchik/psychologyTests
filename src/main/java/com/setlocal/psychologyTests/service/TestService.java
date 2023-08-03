package com.setlocal.psychologyTests.service;

import com.setlocal.psychologyTests.dto.QuestionDto;
import com.setlocal.psychologyTests.dto.TestDto;
import com.setlocal.psychologyTests.model.Question;
import com.setlocal.psychologyTests.model.Test;
import com.setlocal.psychologyTests.repository.TestDao;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
@Scope("session")
@RequiredArgsConstructor
public class TestService {

    private int position = 0;
    private boolean isRun = false;
    private TestDto testDto;

    private final TestDao testDao;

    public void testRun(int id) {
        Test test = testDao.findById(id);
        testDto = TestDto.convertToDto(test);
        if (testDto.getLength() > 0) {
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
        if (position < testDto.getLength())
            position++;
    }

    public void prefPosition() {
        if (position > 0)
            position--;
    }

    public QuestionDto getQuestion() {
        if (testDto.getLength() > position)
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
        return testDto.getLength();
    }

    public List<String> getListTitleTest() {
        return testDao.getListTitleTest();
    }
}