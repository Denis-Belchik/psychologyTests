package com.setlocal.psychologyTests.service;

import com.setlocal.psychologyTests.model.Question;

public interface TestService {

    Question getQuestion();

    String getTitle();

    boolean isTestRunning();

    void testRun(int id);

    void testStop();

    void nextPosition();

    void prefPosition();

    Integer getPosition();

    Integer getSize();

    void setValueAnswer(Integer... id);

    Integer getValueAnswer();

    Question.PossibleAnswer.TypeAnswer getType();
}
