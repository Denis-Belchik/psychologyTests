package com.setlocal.psychologyTests.model;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private int id;

    private String titleTest;

    private int lengthTest;

    private List<Question> questionList = new ArrayList<>();

    public Test() {
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLengthTest() {
//        return lengthTest;
        return questionList.size();
    }

    public void setLengthTest(int lengthTest) {
        this.lengthTest = lengthTest;
    }

    public String getTitleTest() {
        return titleTest;
    }

    public void setTitleTest(String titleTest) {
        this.titleTest = titleTest;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    @Override
    public String toString() {
        return "Test{" +
               "id=" + id +
               ", titleTest='" + titleTest + '\'' +
               ", lengthTest=" + lengthTest +
               ", questionList=" + questionList +
               '}';
    }
}