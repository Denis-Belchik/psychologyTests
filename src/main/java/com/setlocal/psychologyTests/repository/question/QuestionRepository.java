package com.setlocal.psychologyTests.repository.question;

import com.setlocal.psychologyTests.model.Question;

import java.util.List;

public interface QuestionRepository {
    List<Question> findByTestId(Integer id);

}
