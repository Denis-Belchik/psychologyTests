package com.setlocal.psychologyTests.service;

import com.setlocal.psychologyTests.model.Question;
import com.setlocal.psychologyTests.model.Test;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    private final Test test = new Test();

    @Override
    public Question getQuestion(Integer id) {
        return test.getQuestionList().get(id);
    }

    @Override
    public String getTitle() {
        return test.getTitle();
    }
}
