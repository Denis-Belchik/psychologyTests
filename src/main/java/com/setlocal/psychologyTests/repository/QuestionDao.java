package com.setlocal.psychologyTests.repository;

import com.setlocal.psychologyTests.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Scope("session")
@RequiredArgsConstructor
@Repository
public class QuestionDao {
    private final JdbcTemplate jdbcTemplate;
    private final AnswerDao answerDao;

    private static final String FIND_QUESTION_BY_ID_SQL = """
            SELECT id_q,
                body_question,
                type
            FROM psychology_tests.question
            WHERE test_id = ?
            """;

    public List<Question> findById(Integer id) {
        return jdbcTemplate.query(FIND_QUESTION_BY_ID_SQL, (rs, rowNum) ->
                        new Question(
                                rs.getInt("id_q"),
                                rs.getInt("id_q"),
                                rs.getString("body_question"),
                                Question.TypeAnswer.valueOf(rs.getString("type")),
                                answerDao.findListById(rs.getInt("id_q"))
                        )
                , id);
    }

}
