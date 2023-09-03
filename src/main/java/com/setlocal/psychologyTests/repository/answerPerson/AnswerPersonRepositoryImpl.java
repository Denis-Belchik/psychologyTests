package com.setlocal.psychologyTests.repository.answerPerson;

import com.setlocal.psychologyTests.model.AnswerPerson;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Primary
public interface AnswerPersonRepositoryImpl extends AnswerPersonRepository,
        JpaRepository<AnswerPerson, Integer> {

    @Query(value = """
            select replay from psychology_tests.answer_person
            where person_username = :username
            and test_id = :testID
            order by replay desc
            limit 1
            """, nativeQuery = true)
    Optional<Integer> findReplayByUsernameAndTestId(String username, Integer testID);

}
