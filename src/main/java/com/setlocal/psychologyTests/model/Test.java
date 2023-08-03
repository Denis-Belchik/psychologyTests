package com.setlocal.psychologyTests.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    private int id;
    private String title;
    private List<Question> questions = new ArrayList<>();
}