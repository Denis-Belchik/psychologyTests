package com.setlocal.psychologyTests.mapper.model;

import com.setlocal.psychologyTests.dto.model.AnswerPersonDTO;
import com.setlocal.psychologyTests.model.AnswerPerson;
import org.springframework.stereotype.Component;

@Component
public class AnswerPersonMapper {

    public AnswerPersonDTO mapToDTO(AnswerPerson answerPerson) {
        AnswerPersonDTO answerPersonDTO = new AnswerPersonDTO();
        answerPersonDTO.setPositionAnswer(answerPerson.getPositionAnswer());
        answerPersonDTO.setUsername(answerPerson.getUsername());
        answerPersonDTO.setQuestionID(answerPersonDTO.getQuestionID());
        return answerPersonDTO;
    }

    public AnswerPerson mapToEntity(AnswerPersonDTO answerPersonDTO) {
        AnswerPerson answerPerson = new AnswerPerson();
        answerPerson.setPositionAnswer(answerPersonDTO.getPositionAnswer());
        answerPerson.setUsername(answerPersonDTO.getUsername());
        answerPerson.setQuestionID(answerPersonDTO.getQuestionID());
        return answerPerson;
    }

}