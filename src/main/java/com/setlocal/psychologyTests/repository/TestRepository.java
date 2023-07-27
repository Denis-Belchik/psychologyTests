package com.setlocal.psychologyTests.repository;

import com.setlocal.psychologyTests.mapper.TestMapper;
import com.setlocal.psychologyTests.model.Test;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Scope("session")
@RequiredArgsConstructor
public class TestRepository {

    @Getter
    private Test test;
    private final JdbcTemplate jdbcTemplate;

    public void initTest(int id) {
        test = null;
        String FIND_TEST_BY_ID_SQL = """
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
        test = jdbcTemplate.queryForObject(FIND_TEST_BY_ID_SQL, new TestMapper(), id);
    }

    public List<String> getListTitleTest(){
        String FIND_LIST_TITLE_TEST_SQL = """
                SELECT id_t,
                    title_test
                FROM psychology_tests.test
                """;
        return jdbcTemplate.query(FIND_LIST_TITLE_TEST_SQL, (rs, rowNum) -> rs.getString("title_test"));

    }

}