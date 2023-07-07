package com.setlocal.psychologyTests.service;

import com.setlocal.psychologyTests.model.Question;

public interface TestService {

    Question getQuestion();

    Question getNextQuestion();

    String getTitle();

    void setValueAnswer(Integer id);

    Integer getValueAnswer();
}
