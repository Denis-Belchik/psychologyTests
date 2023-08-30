package com.setlocal.psychologyTests.repository.answer;

import com.setlocal.psychologyTests.model.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@RequiredArgsConstructor
@Repository
//@Primary
public class AnswerDAOImpl implements AnswerRepository{

    private final JdbcTemplate jdbcTemplate;

    private static final String FIND_ANSWER_BY_QUESTION_ID_SQL = """
            SELECT id_a,
                answer
            FROM psychology_tests.answer
            WHERE question_id = ?
            """;

    @Override
    public List<Answer> findByQuestionId(Integer id) {
        return jdbcTemplate.query(FIND_ANSWER_BY_QUESTION_ID_SQL, (rs, rowNum) -> {
            Answer answer = new Answer();
            answer.setId(rs.getInt("id_a"));
            answer.setAnswer(rs.getString("answer"));
            return answer;
        }, id);
    }
}
