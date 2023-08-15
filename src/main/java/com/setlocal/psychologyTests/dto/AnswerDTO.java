package com.setlocal.psychologyTests.dto;

import com.setlocal.psychologyTests.model.Answer;
import lombok.*;

@Data
@NoArgsConstructor
public class AnswerDTO implements MapToDTO<AnswerDTO, Answer> {
    private int id;
    private String answer;

    @Override
    public AnswerDTO convertToDto(Answer answer) {
        AnswerDTO answerDTO = new AnswerDTO();
        if (answer != null) {
            answerDTO.setId(answer.getId());
            answerDTO.setAnswer(answer.getAnswer());
        }
        return answerDTO;
    }
}