package com.setlocal.psychologyTests.dto.model;

import com.setlocal.psychologyTests.dto.MapToDTO;
import com.setlocal.psychologyTests.model.Answer;
import lombok.*;

@Data
@NoArgsConstructor
public class AnswerDTO implements MapToDTO<AnswerDTO, Answer> {
    private int id;
    private int position;
    private String answer;

    @Override
    public AnswerDTO convertToDto(Answer answer) {
        AnswerDTO answerDTO = new AnswerDTO();
        if (answer != null) {
            answerDTO.setId(answer.getId());
            answerDTO.setPosition(answer.getPosition());
            answerDTO.setAnswer(answer.getAnswer());
        }
        return answerDTO;
    }
}