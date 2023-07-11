package com.setlocal.psychologyTests.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question {

    private final int ID;

    private final String bodyQuestion;

    private final List<PossibleAnswer> answers = new ArrayList<>();

    public Question(Integer ID, String bodyQuestion, PossibleAnswer... possibleAnswer) {
        this.ID = ID;
        this.bodyQuestion = bodyQuestion;
        this.answers.addAll(Arrays.asList(possibleAnswer));
    }

    public int getIDQuestion(){
        return ID;
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
        private final TypeAnswer type;

        public PossibleAnswer(int ID, String answerBody, TypeAnswer type) {
            this.ID = ID;
            this.possibleAnswer = answerBody;
            this.type = type;
        }

        public String getPossibleAnswer() {
            return possibleAnswer;
        }

        public int getID() {
            return ID;
        }

        public TypeAnswer getType(){
            return type;
        }

        public enum TypeAnswer {
            RADIO,
            CHECKBOX
        }

    }
}