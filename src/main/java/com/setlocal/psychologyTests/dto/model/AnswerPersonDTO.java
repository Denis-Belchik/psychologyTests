package com.setlocal.psychologyTests.dto.model;

import lombok.Data;

import java.util.List;

@Data
public class AnswerPersonDTO {

    private String username;
    private Integer questionID;
    private List<Integer> positionAnswer;

}