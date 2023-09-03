package com.setlocal.psychologyTests.dto.model;

import lombok.Data;

import java.util.List;

@Data
public class AnswerPersonDTO {

    private String username;
    private Integer questionID;
    private Integer replay;
    private Integer testId;
    private Integer replacement;
    private List<Integer> positionAnswer;

}