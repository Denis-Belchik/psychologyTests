package com.setlocal.psychologyTests.repository.test;

import com.setlocal.psychologyTests.model.Test;
import com.setlocal.psychologyTests.repository.question.QuestionRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
//@Primary
public class TestDAOImpl implements TestRepository {
    @Getter
    private final Test test = null;
    private final JdbcTemplate jdbcTemplate;
    private final QuestionRepository questionRepository;
    private static final String FIND_LIST_TITLE_TEST_SQL = """
            SELECT id_t,
                title,
                size
            FROM psychology_tests.test
            """;
    private static final String FIND_TEST_BY_ID_SQL = """
            SELECT id_t,
                title,
                size
            FROM psychology_tests.test
            WHERE id_t = ?
            """;

    public Optional<Test> findById(Integer id) {
        return jdbcTemplate.queryForStream(FIND_TEST_BY_ID_SQL, (rs, rowNum) -> {
                    Test test = new Test();
                    test.setId(rs.getInt("id_t"));
                    test.setSize(rs.getInt("size"));
                    test.setTitle(rs.getString("title"));
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
                    test.setSize(rs.getInt("size"));
            test.setTitle(rs.getString("title"));
            return test;
                });
    }

}
