package com.setlocal.psychologyTests.service;

import com.setlocal.psychologyTests.model.Question;
import com.setlocal.psychologyTests.model.Test;
import org.springframework.stereotype.Service;


@Service
public class TestServiceImpl implements TestService {

    private final Test test;
    private int IDQuest = 0;
    private Integer sumAnswer = 0;

    public TestServiceImpl(Test test) {
        this.test = test;
    }

    @Override
    public void setValueAnswer(Integer id){
        sumAnswer += id;
    }

    @Override
    public Integer getValueAnswer(){
        return sumAnswer;
    }

    @Override
    public boolean isTestRunning(){
        return test.isTestRunning();
    }

    @Override
    public void setTestRunning(boolean isRun){
        test.setTestRunning(isRun);
    }

    @Override
    public Question getQuestion() {
        if (test.getLength() > IDQuest)
            return test.getQuestionList().get(IDQuest++);
        return null;
    }

    @Override
    public String getTitle() {
        return test.getTitle();
    }
}
