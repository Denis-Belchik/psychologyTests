package com.setlocal.psychologyTests.dto.model;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
public class TestDTO {

    private int id;
    private String title;
    private int size;
    private List<QuestionDTO> questions;

}