package com.setlocal.psychologyTests.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class Test {

    private String title;

    private int length = 0;

    private List<Question> questionList = new ArrayList<>();

    public Test() {
        this.title = "Первое тестирование";
        this.questionList.add(new Question("Вопрос1", "Вопрос1, Ответ1", "Вопрос1, Ответ2", "Вопрос1, Ответ3", "Вопрос1, Ответ4"));
        this.length++;
        //        System.out.println("questionList.get(0).getListAnswers().get(0).getIDAnswer() = " + questionList.get(0).getListAnswers().get(0).getIDAnswer());
//        System.out.println("questionList.get(0).getListAnswers().get(0).getIDAnswer() = " + questionList.get(0).getListAnswers().get(1).getIDAnswer());
//        System.out.println("questionList.get(0).getListAnswers().get(0).getIDAnswer() = " + questionList.get(0).getListAnswers().get(2).getIDAnswer());
//        System.out.println("questionList.get(0).getListAnswers().get(0).getIDAnswer() = " + questionList.get(0).getListAnswers().get(3).getIDAnswer());
        this.questionList.add(new Question("Вопрос2", "Вопрос2, Ответ1", "Вопрос2, Ответ2", "Вопрос2, Ответ3", "Вопрос2, Ответ4"));
        this.length++;
        this.questionList.add(new Question("Вопрос3", "Ответ1", "Ответ2", "Ответ3", "Ответ4"));
        this.length++;
        this.questionList.add(new Question("Вопрос4", "Ответ1", "Ответ2", "Ответ3", "Ответ4"));
        this.length++;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getListQuestion() {
        return questionList;
    }

    public void setListQuestion(List<Question> questionList) {
        this.questionList = questionList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(title, test.title) && Objects.equals(questionList, test.questionList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, questionList);
    }

    @Override
    public String toString() {
        return "Test{" +
                "title='" + title + '\'' +
                ", questionList=" + questionList +
                '}';
    }
}
