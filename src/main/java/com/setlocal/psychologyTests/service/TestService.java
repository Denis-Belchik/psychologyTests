package com.setlocal.psychologyTests.service;

import com.setlocal.psychologyTests.model.Question;

public interface TestService {

    Question getQuestion(Integer id);

    String getTitle();
}
