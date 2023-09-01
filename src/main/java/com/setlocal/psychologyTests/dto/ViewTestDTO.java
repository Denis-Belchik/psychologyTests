package com.setlocal.psychologyTests.dto;

import com.setlocal.psychologyTests.dto.model.AnswerDTO;
import com.setlocal.psychologyTests.model.Question;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ViewTestDTO {

    private String title;
    private int size;
    private int position;
    private String question;
    private Question.TypeAnswer typeAnswer;
    private List<AnswerDTO> answers;

}
