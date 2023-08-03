package com.setlocal.psychologyTests.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    public enum TypeAnswer {
        RADIO,
        CHECKBOX
    }

    private int id;
    private int test_id;
    private String bodyQuestion;
    private TypeAnswer type;
    private List<Answer> answers;
}