package com.setlocal.psychologyTests.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question {

    public enum TypeAnswer {
        RADIO,
        CHECKBOX
    }

    private int ID;

    private String bodyQuestion;

    private TypeAnswer type;

    private List<PossibleAnswer> answers = new ArrayList<>();

    public Question(Integer ID, String bodyQuestion, TypeAnswer type, PossibleAnswer... possibleAnswer) {
        this.ID = ID;
        this.bodyQuestion = bodyQuestion;
        this.answers.addAll(Arrays.asList(possibleAnswer));
        this.type = type;
    }

    public Question() {
    }

    @Override
    public String toString() {
        return "Question{" +
               "ID=" + ID +
               ", bodyQuestion='" + bodyQuestion + '\'' +
               ", type=" + type +
               ", answers=" + answers +
               '}';
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setBodyQuestion(String bodyQuestion) {
        this.bodyQuestion = bodyQuestion;
    }

    public void setType(TypeAnswer type) {
        this.type = type;
    }

    public void setAnswers(List<PossibleAnswer> answers) {
        this.answers = answers;
    }

    public int getIDQuestion() {
        return ID;
    }

    public TypeAnswer getType() {
        return type;
    }

    public String getBodyQuestion() {
        return bodyQuestion;
    }

    public List<PossibleAnswer> getAnswersList() {
        Collections.shuffle(answers);
        return answers;
    }

    public static class PossibleAnswer {
        private int ID;
        private String answer;

        public PossibleAnswer(int ID, String answerBody) {
            this.ID = ID;
            this.answer = answerBody;
        }

        public PossibleAnswer() {
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public String getAnswer() {
            return answer;
        }

        public int getID() {
            return ID;
        }

        @Override
        public String toString() {
            return "PossibleAnswer{" +
                   "ID=" + ID +
                   ", answer='" + answer + '\'' +
                   '}';
        }
    }
}