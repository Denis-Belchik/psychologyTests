package com.setlocal.psychologyTests.model;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Answer {
    private int id;
    private int question_id;
    private String answer;
}
