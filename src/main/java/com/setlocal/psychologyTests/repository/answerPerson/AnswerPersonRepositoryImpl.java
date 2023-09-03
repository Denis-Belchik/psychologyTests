package com.setlocal.psychologyTests.repository.answerPerson;

import com.setlocal.psychologyTests.dto.model.AnswerPersonDTO;
import com.setlocal.psychologyTests.model.AnswerPerson;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface AnswerPersonRepositoryImpl extends AnswerPersonRepository, JpaRepository<AnswerPerson, Integer> {
}
