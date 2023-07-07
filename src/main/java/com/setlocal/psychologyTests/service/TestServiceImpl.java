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
    public Question getQuestion() {
        return test.getListQuestion().get(IDQuest);
    }

    @Override
    public Question getNextQuestion() {
        System.out.println("IDQuest = " + IDQuest);
        if (test.getLength() > IDQuest)
            return test.getListQuestion().get(IDQuest++);
        return null;
    }

    @Override
    public String getTitle() {
        return test.getTitle();
    }
}
