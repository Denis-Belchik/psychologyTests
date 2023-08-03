package com.setlocal.psychologyTests.repository;

import com.setlocal.psychologyTests.model.Test;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Scope("session")
@RequiredArgsConstructor
@Repository
public class TestDao {
    @Getter
    private final Test test = null;
    private final JdbcTemplate jdbcTemplate;
    private final QuestionDao questionDao;
    private static final String FIND_LIST_TITLE_TEST_SQL = """
            SELECT id_t,
                title_test
            FROM psychology_tests.test
            """;
    private static final String FIND_TEST_BY_ID_SQL = """
            SELECT id_t,
                title_test
            FROM psychology_tests.test
            WHERE id_t = ?
            """;

    public Test findById(Integer id) {
        return jdbcTemplate.queryForObject(FIND_TEST_BY_ID_SQL, (rs, rowNum) ->
                        new Test(
                                rs.getInt("id_t"),
                                rs.getString("title_test"),
                                questionDao.findById(id)
                        ), id);
    }

    public List<String> getListTitleTest() {
        return jdbcTemplate.query(FIND_LIST_TITLE_TEST_SQL,
                (rs, rowNum) -> rs.getString("title_test"));
    }

}
