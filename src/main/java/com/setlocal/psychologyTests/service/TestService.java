package com.setlocal.psychologyTests.service;

import com.setlocal.psychologyTests.model.Question;
import com.setlocal.psychologyTests.model.Test;
import com.setlocal.psychologyTests.repository.TestRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("session")
@RequiredArgsConstructor
public class TestService {

    @Getter
    private int position = 0;
    @Getter
    private boolean isRun = false;
    private Test test;
    private final TestRepository testRepository;

    public void testRun(int id) {
        testRepository.initTest(id);
        test = testRepository.getTest();
        if (test.getLength() > 0) {
            isRun = true;
        } else {
            testStop();
        }
    }

    public void testStop() {
        position = 0;
        test = null;
    }

    public void nextPosition() {
        if (position < test.getLength())
            position++;
    }

    public void prefPosition() {
        if (position > 0)
            position--;
    }

    public Question getQuestion() {
        if (test.getLength() > position)
            return test.getQuestions().get(position);
        return null;
    }

    public Question.TypeAnswer getQuestionType() {
        return test.getQuestions().get(position).getType();
    }

    public String getTestTitle() {
        return test.getTitle();
    }

    public Integer getTestSize() {
        return test.getLength();
    }

    public List<String> getListTitleTest() {
        return testRepository.getListTitleTest();
    }
}