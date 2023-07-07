package com.setlocal.psychologyTests.model;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private String body;

    private List<Answer> answers = new ArrayList<>();

    public Question() {
    }

    public Question(String body,
                    String answer0,
                    String answer1,
                    String answer2,
                    String answer3) {
        this.body = body;
        Answer answerTemp;

        answerTemp= new Answer(answer0);
        answerTemp.setID(1);
        this.answers.add(answerTemp);

        answerTemp= new Answer(answer1);
        answerTemp.setID(2);
        this.answers.add(answerTemp);

        answerTemp= new Answer(answer2);
        answerTemp.setID(3);
        this.answers.add(answerTemp);

        answerTemp= new Answer(answer3);
        answerTemp.setID(4);
        this.answers.add(answerTemp);
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<Answer> getListAnswers() {
        return answers;
    }

    public void setListAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public static class Answer{

        private String answerBody;

        private int ID;

        public Answer(String answerBody) {
            this.answerBody = answerBody;
//            this.ID++;
        }

        public String getAnswerBody() {
            return answerBody;
        }

        public void setAnswerBody(String answerBody) {
            this.answerBody = answerBody;
        }

        public int getIDAnswer() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }
    }
}