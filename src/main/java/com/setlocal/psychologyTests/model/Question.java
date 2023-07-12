package com.setlocal.psychologyTests.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question {

    public enum TypeAnswer {
        RADIO,
        CHECKBOX
    }

    private final int ID;

    private final String bodyQuestion;

    private final TypeAnswer type;

    private final List<PossibleAnswer> answers = new ArrayList<>();

    public Question(Integer ID, String bodyQuestion, TypeAnswer type, PossibleAnswer... possibleAnswer) {
        this.ID = ID;
        this.bodyQuestion = bodyQuestion;
        this.answers.addAll(Arrays.asList(possibleAnswer));
        this.type = type;
    }

    public int getIDQuestion(){
        return ID;
    }

    public TypeAnswer getType(){
        return type;
    }

    public String getBodyQuestion() {
        return bodyQuestion;
    }

    public List<PossibleAnswer> getAnswersList() {
        return answers;
    }

    public static class PossibleAnswer {
        private final String possibleAnswer;
        private final int ID;

        public PossibleAnswer(int ID, String answerBody) {
            this.ID = ID;
            this.possibleAnswer = answerBody;
        }

        public String getPossibleAnswer() {
            return possibleAnswer;
        }

        public int getID() {
            return ID;
        }

    }
}