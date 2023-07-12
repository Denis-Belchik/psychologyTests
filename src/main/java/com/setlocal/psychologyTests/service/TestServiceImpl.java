package com.setlocal.psychologyTests.service;

import com.setlocal.psychologyTests.model.Question;
import com.setlocal.psychologyTests.model.Test;
import com.setlocal.psychologyTests.repository.TestRepository;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    private Test test;

    private int position = 0;

    private boolean isRun = false;

    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public boolean isTestRunning() {
        return isRun;
    }

    @Override
    public void testRun(int id) {
        testRepository.init(id);
        test = testRepository.getTest();
        isRun = true;
    }

    @Override
    public void testStop() {
        position = 0;
        test = null;
    }

    @Override
    public void nextPosition() {
        if (position < test.getLengthTest())
            position++;
    }

    @Override
    public void prefPosition() {
        if (position > 0)
            position--;
    }

    @Override
    public Question getQuestion() {
        if (test.getLengthTest() > position)
            return test.getQuestionList().get(position);
        return null;
    }

    @Override
    public Question.TypeAnswer getType(){
        return test.getQuestionList().get(position).getType();
    }

    @Override
    public Integer getPosition() {
        return position;
    }

    @Override
    public String getTitle() {
        return test.getTitleTest();
    }

    @Override
    public Integer getSize() {
        return test.getLengthTest();
    }

}