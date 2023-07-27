package com.setlocal.psychologyTests.Mapper;

import com.setlocal.psychologyTests.model.Question;
import com.setlocal.psychologyTests.model.Question.PossibleAnswer;
import com.setlocal.psychologyTests.model.Test;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestMapper implements RowMapper<Test> {

    @Override
    public Test mapRow(ResultSet rs, int rowNum) throws SQLException {
        Test test = new Test();
        Question question = new Question();
        List<Question> questionList = new ArrayList<>();
        PossibleAnswer possibleAnswer = new PossibleAnswer();
        List<PossibleAnswer> possibleAnswerList = new ArrayList<>();
        int id_q = 1;
        boolean flag = true;
        test.setId(rs.getInt("id_t"));
        test.setTitleTest(rs.getString("title_test"));
        do {
            possibleAnswer = new PossibleAnswer();
            possibleAnswer.setID(rs.getInt("position"));
            possibleAnswer.setAnswer(rs.getString("answer"));
            if (rs.getInt("id_q") == id_q) {
                possibleAnswerList.add(possibleAnswer);
                if (flag) {
                    question = new Question();
                    question.setID(rs.getInt("id_q"));
                    question.setBodyQuestion(rs.getString("body_question"));
                    question.setType(Question.TypeAnswer.valueOf(rs.getString("type")));
                    questionList.add(question);
                    flag = false;
                }
            } else {
                question.setAnswers(possibleAnswerList);
                possibleAnswerList = new ArrayList<>();
                possibleAnswerList.add(possibleAnswer);
                id_q++;
                flag = true;
            }
        } while (rs.next());
        question.setAnswers(possibleAnswerList);
        test.setQuestionList(questionList);
//        System.out.println(test);
        return test;
    }
}
