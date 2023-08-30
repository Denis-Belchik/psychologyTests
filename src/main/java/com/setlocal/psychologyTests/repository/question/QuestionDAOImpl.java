package com.setlocal.psychologyTests.repository.question;

import com.setlocal.psychologyTests.model.Question;
import com.setlocal.psychologyTests.repository.answer.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
//@Primary
public class QuestionDAOImpl implements QuestionRepository {
    private final JdbcTemplate jdbcTemplate;
    private final AnswerRepository answerRepository;

    private static final String FIND_QUESTION_BY_ID_SQL = """
            SELECT id_q,
                body,
                type
            FROM psychology_tests.question
            WHERE test_id = ?
            """;

    @Override
    public List<Question> findByTestId(Integer id) {
        return jdbcTemplate.query(FIND_QUESTION_BY_ID_SQL, (rs, rowNum) -> {
                    Question question = new Question();
                    question.setId(rs.getInt("id_q"));
                    question.setBody(rs.getString("body"));
                    question.setType(Question.TypeAnswer.valueOf(rs.getString("type")));
                    question.setAnswers(answerRepository.findByQuestionId(rs.getInt("id_q")));
                    return question;
                }
                , id);
    }

}