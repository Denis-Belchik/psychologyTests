package com.setlocal.psychologyTests.repository;

import com.setlocal.psychologyTests.model.Question;

import java.util.List;

public interface QuestionRepository {
    List<Question> findByTestId(Integer id);

}
