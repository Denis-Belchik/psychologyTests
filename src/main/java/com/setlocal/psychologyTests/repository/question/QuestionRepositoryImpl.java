package com.setlocal.psychologyTests.repository.question;

import com.setlocal.psychologyTests.model.Question;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface QuestionRepositoryImpl extends QuestionRepository, JpaRepository<Question, Integer> {

}
