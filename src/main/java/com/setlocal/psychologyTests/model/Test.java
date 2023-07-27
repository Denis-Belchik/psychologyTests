package com.setlocal.psychologyTests.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Test {

    private int id;
    private String title;
    private int length;
    private List<Question> questions = new ArrayList<>();

}