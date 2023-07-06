package com.setlocal.psychologyTests.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Question {

    private String body;

    private List<String> answer = new ArrayList<>();

    public Question() {
    }

    public Question(String body,
                    String answer0,
                    String answer1,
                    String answer2,
                    String answer3) {
        this.body = body;
        this.answer.add(answer0);
        this.answer.add(answer1);
        this.answer.add(answer2);
        this.answer.add(answer3);
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<String> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }


}
