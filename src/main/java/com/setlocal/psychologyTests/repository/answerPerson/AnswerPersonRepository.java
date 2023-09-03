package com.setlocal.psychologyTests.repository.answerPerson;

import com.setlocal.psychologyTests.model.AnswerPerson;

import java.util.Optional;

public interface AnswerPersonRepository {

    AnswerPerson save(AnswerPerson answerPerson);
    Optional<Integer> findReplayByUsernameAndTestId(String username, Integer testID);

}
