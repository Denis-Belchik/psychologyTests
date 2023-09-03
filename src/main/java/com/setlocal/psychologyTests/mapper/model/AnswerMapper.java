package com.setlocal.psychologyTests.mapper.model;

import com.setlocal.psychologyTests.dto.model.AnswerDTO;
import com.setlocal.psychologyTests.model.Answer;
import org.springframework.stereotype.Component;

@Component
public class AnswerMapper {

    public AnswerDTO mapToDto(Answer answer) {
        AnswerDTO answerDTO = new AnswerDTO();
        if (answer != null) {
            answerDTO.setId(answer.getId());
            answerDTO.setPosition(answer.getPosition());
            answerDTO.setAnswer(answer.getAnswer());
        }
        return answerDTO;
    }

}
