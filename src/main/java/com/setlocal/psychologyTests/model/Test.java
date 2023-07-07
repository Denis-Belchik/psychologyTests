package com.setlocal.psychologyTests.model;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Test {

    private String title;

    private List<Question> questionList = new ArrayList<>();

    public Test() {
        this.title = "Первое тестирование";
        this.questionList.add(new Question("Вопрос1", "Вопрос1, Ответ1","Вопрос1, Ответ2","Вопрос1, Ответ3","Вопрос1, Ответ4"));
        this.questionList.add(new Question("Вопрос2", "Вопрос2, Ответ1","Вопрос2, Ответ2","Вопрос2, Ответ3","Вопрос2, Ответ4"));
        this.questionList.add(new Question("Вопрос3", "Ответ1","Ответ2","Ответ3","Ответ4"));
        this.questionList.add(new Question("Вопрос4", "Ответ1","Ответ2","Ответ3","Ответ4"));

    }

//    public Test(String title, List<Question> questionList) {
//        this.title = title;
//        this.questionList = questionList;
//    }

//    @PostConstruct
//    public void init(){
//        this.title = "Первое тестирование";
//        this.questionList.add(new Question("Вопрос1", "Ответ1","Ответ2","Ответ3","Ответ4"));
//        this.questionList.add(new Question("Вопрос2", "Ответ1","Ответ2","Ответ3","Ответ4"));
//        this.questionList.add(new Question("Вопрос3", "Ответ1","Ответ2","Ответ3","Ответ4"));
//        this.questionList.add(new Question("Вопрос4", "Ответ1","Ответ2","Ответ3","Ответ4"));
//        System.out.println("init");
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
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
