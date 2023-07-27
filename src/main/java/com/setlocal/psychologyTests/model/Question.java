package com.setlocal.psychologyTests.model;

import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Question {

    public enum TypeAnswer {
        RADIO,
        CHECKBOX
    }

    private int id;
    private String bodyQuestion;
    private TypeAnswer type;
    private List<PossibleAnswer> answers = new ArrayList<>();

    public List<PossibleAnswer> getAnswersList() {
        Collections.shuffle(answers);
        return answers;
    }

}