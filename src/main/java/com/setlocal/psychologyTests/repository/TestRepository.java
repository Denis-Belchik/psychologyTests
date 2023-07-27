package com.setlocal.psychologyTests.repository;

import com.setlocal.psychologyTests.Mapper.TestMapper;
import com.setlocal.psychologyTests.model.Question;
import com.setlocal.psychologyTests.model.Test;
import org.springframework.boot.autoconfigure.jdbc.JdbcProperties;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Scope("session")
public class TestRepository {

    private final String FIND_TEST_BY_ID_SQL = """
            SELECT t.id_t,
                t.title_test,
                q.id_q,
                q.body_question,
                q.type,
                pa.position,
                pa.answer
            FROM psychology_tests.test AS t
            LEFT JOIN psychology_tests.question AS q on t.id_t = q.test_id
            LEFT JOIN psychology_tests.possible_answer AS pa on q.id_q = pa.question_id
            WHERE t.id_t = ?
            """;

    private Test test;

    private final JdbcTemplate jdbcTemplate;

    public TestRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void init(int id) {
        test = new Test();
        List<Question> question = new ArrayList<>();
        test = jdbcTemplate.queryForObject(FIND_TEST_BY_ID_SQL, new Object[]{id}, new TestMapper());

    }

    public Test getTest() {
        return test;
    }

}