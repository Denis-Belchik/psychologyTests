package com.setlocal.psychologyTests.repository;

import com.setlocal.psychologyTests.model.Question;
import com.setlocal.psychologyTests.model.Test;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {

    private Test test;

    public void init(int id) {
        test = new Test();
        if (id == 1) {
            test.setTitleTest("Первое тестирование");
            test.setLengthTest(4);
            test.getQuestionList().add(new Question(1, "Вопрос1",
                    new Question.PossibleAnswer(1, "Вопрос1, Ответ1", Question.PossibleAnswer.TypeAnswer.RADIO),
                    new Question.PossibleAnswer(2, "Вопрос1, Ответ2", Question.PossibleAnswer.TypeAnswer.RADIO),
                    new Question.PossibleAnswer(3, "Вопрос1, Ответ3", Question.PossibleAnswer.TypeAnswer.RADIO),
                    new Question.PossibleAnswer(4, "Вопрос1, Ответ4", Question.PossibleAnswer.TypeAnswer.RADIO)));
            test.getQuestionList().add(new Question(2, "Вопрос2",
                    new Question.PossibleAnswer(1, "Вопрос2, Ответ1", Question.PossibleAnswer.TypeAnswer.RADIO),
                    new Question.PossibleAnswer(2, "Вопрос2, Ответ2", Question.PossibleAnswer.TypeAnswer.RADIO),
                    new Question.PossibleAnswer(3, "Вопрос2, Ответ3", Question.PossibleAnswer.TypeAnswer.RADIO),
                    new Question.PossibleAnswer(4, "Вопрос2, Ответ4", Question.PossibleAnswer.TypeAnswer.RADIO),
                    new Question.PossibleAnswer(5, "Вопрос2, Ответ5", Question.PossibleAnswer.TypeAnswer.RADIO)));
            test.getQuestionList().add(new Question(3, "Вопрос3",
                    new Question.PossibleAnswer(1, "Вопрос3, Ответ1", Question.PossibleAnswer.TypeAnswer.RADIO),
                    new Question.PossibleAnswer(2, "Вопрос3, Ответ2", Question.PossibleAnswer.TypeAnswer.RADIO),
                    new Question.PossibleAnswer(3, "Вопрос3, Ответ3", Question.PossibleAnswer.TypeAnswer.RADIO),
                    new Question.PossibleAnswer(4, "Вопрос3, Ответ4", Question.PossibleAnswer.TypeAnswer.RADIO)));
            test.getQuestionList().add(new Question(4, "Вопрос4",
                    new Question.PossibleAnswer(1, "Вопрос4, Ответ1", Question.PossibleAnswer.TypeAnswer.RADIO),
                    new Question.PossibleAnswer(2, "Вопрос4, Ответ2", Question.PossibleAnswer.TypeAnswer.RADIO),
                    new Question.PossibleAnswer(3, "Вопрос4, Ответ3", Question.PossibleAnswer.TypeAnswer.RADIO),
                    new Question.PossibleAnswer(4, "Вопрос4, Ответ4", Question.PossibleAnswer.TypeAnswer.RADIO)));
        } else if (id == 2) {
            test.setTitleTest("Второе тестирование");
            test.setLengthTest(5);
            test.getQuestionList().add(new Question(1, "Вопрос1",
                    new Question.PossibleAnswer(1, "Вопрос1, Ответ1", Question.PossibleAnswer.TypeAnswer.CHECKBOX),
                    new Question.PossibleAnswer(2, "Вопрос1, Ответ2", Question.PossibleAnswer.TypeAnswer.CHECKBOX),
                    new Question.PossibleAnswer(3, "Вопрос1, Ответ3", Question.PossibleAnswer.TypeAnswer.CHECKBOX),
                    new Question.PossibleAnswer(4, "Вопрос1, Ответ4", Question.PossibleAnswer.TypeAnswer.CHECKBOX)));
            test.getQuestionList().add(new Question(2, "Вопрос2",
                    new Question.PossibleAnswer(1, "Вопрос2, Ответ1", Question.PossibleAnswer.TypeAnswer.RADIO),
                    new Question.PossibleAnswer(2, "Вопрос2, Ответ2", Question.PossibleAnswer.TypeAnswer.RADIO),
                    new Question.PossibleAnswer(3, "Вопрос2, Ответ3", Question.PossibleAnswer.TypeAnswer.RADIO),
                    new Question.PossibleAnswer(4, "Вопрос2, Ответ4", Question.PossibleAnswer.TypeAnswer.RADIO)));
            test.getQuestionList().add(new Question(3, "Вопрос3",
                    new Question.PossibleAnswer(1, "Вопрос3, Ответ1", Question.PossibleAnswer.TypeAnswer.CHECKBOX),
                    new Question.PossibleAnswer(2, "Вопрос3, Ответ2", Question.PossibleAnswer.TypeAnswer.CHECKBOX),
                    new Question.PossibleAnswer(3, "Вопрос3, Ответ3", Question.PossibleAnswer.TypeAnswer.CHECKBOX),
                    new Question.PossibleAnswer(4, "Вопрос3, Ответ4", Question.PossibleAnswer.TypeAnswer.CHECKBOX)));
            test.getQuestionList().add(new Question(4, "Вопрос4",
                    new Question.PossibleAnswer(1, "Вопрос4, Ответ1", Question.PossibleAnswer.TypeAnswer.RADIO),
                    new Question.PossibleAnswer(2, "Вопрос4, Ответ2", Question.PossibleAnswer.TypeAnswer.RADIO),
                    new Question.PossibleAnswer(3, "Вопрос4, Ответ3", Question.PossibleAnswer.TypeAnswer.RADIO)));
            test.getQuestionList().add(new Question(5, "Вопрос5",
                    new Question.PossibleAnswer(1, "Вопрос5, Ответ1", Question.PossibleAnswer.TypeAnswer.RADIO),
                    new Question.PossibleAnswer(2, "Вопрос5, Ответ2", Question.PossibleAnswer.TypeAnswer.RADIO),
                    new Question.PossibleAnswer(3, "Вопрос5, Ответ3", Question.PossibleAnswer.TypeAnswer.RADIO),
                    new Question.PossibleAnswer(4, "Вопрос5, Ответ4", Question.PossibleAnswer.TypeAnswer.RADIO)));
        }
    }

    public Test getTest() {
        return test;
    }

}