package com.setlocal.psychologyTests.dto.model;

import com.setlocal.psychologyTests.model.Question;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
public class QuestionDTO {

    private int id;
    private String body;
    private Question.TypeAnswer type;
    private List<AnswerDTO> answers;

}