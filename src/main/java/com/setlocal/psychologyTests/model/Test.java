package com.setlocal.psychologyTests.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Test {

    private final String title;

    private final int length;

    private boolean isRun = false;

    private final List<Question> questionList = new ArrayList<>();

    public Test() {
        this.title = "Первое тестирование";
        this.questionList.add(new Question("Вопрос1", "Вопрос1, Ответ1", "Вопрос1, Ответ2", "Вопрос1, Ответ3", "Вопрос1, Ответ4"));
        this.questionList.add(new Question("Вопрос2", "Вопрос2, Ответ1", "Вопрос2, Ответ2", "Вопрос2, Ответ3", "Вопрос2, Ответ4"));
        this.questionList.add(new Question("Вопрос3", "Ответ1", "Ответ2", "Ответ3", "Ответ4"));
        this.questionList.add(new Question("Вопрос4", "Ответ1", "Ответ2", "Ответ3", "Ответ4"));
        this.length = 4;
    }

    public boolean isTestRunning(){
        return isRun;
    }

    public void setTestRunning(boolean isRun){
        this.isRun = isRun;
    }

    public int getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }
}