package com.setlocal.psychologyTests.model;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private String titleTest;

    private int lengthTest;

    private final List<Question> questionList = new ArrayList<>();

    public int getLengthTest() {
        return lengthTest;
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
}