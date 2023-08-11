package com.setlocal.psychologyTests.repository;

import com.setlocal.psychologyTests.model.Test;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
//@Primary
public class TestDaoImpl implements TestRepository {
    @Getter
    private final Test test = null;
    private final JdbcTemplate jdbcTemplate;
    private final QuestionRepository questionRepository;
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

    public Optional<Test> findById(Integer id) {
        return jdbcTemplate.queryForStream(FIND_TEST_BY_ID_SQL, (rs, rowNum) -> {
                    Test test = new Test();
                    test.setId(rs.getInt("id_t"));
                    test.setTitle(rs.getString("title_test"));
                    test.setQuestions(questionRepository.findByTestId(id));
                    return test;
                }
                , id).findAny();
    }

    public List<Test> findAll() {
        return jdbcTemplate.query(FIND_LIST_TITLE_TEST_SQL,
                (rs, rowNum) -> {
            Test test = new Test();
            test.setId(rs.getInt("id_t"));
            test.setTitle(rs.getString("title_test"));
            return test;
                });
    }

}
