package com.setlocal.psychologyTests.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    private int id;
    private String title;
    private List<Question> questions = new ArrayList<>();
}