package com.setlocal.psychologyTests.service;

import com.setlocal.psychologyTests.model.Question;

public interface TestService {

    Question getQuestion();

    String getTitle();

    void setValueAnswer(Integer id);

    Integer getValueAnswer();

    boolean isTestRunning();

    void setTestRunning(boolean isRun);
}
