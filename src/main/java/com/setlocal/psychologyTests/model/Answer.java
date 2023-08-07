package com.setlocal.psychologyTests.model;

import lombok.*;

@Data
@NoArgsConstructor
public class Answer {
    private int id;
    private int question_id;
    private String answer;
}
