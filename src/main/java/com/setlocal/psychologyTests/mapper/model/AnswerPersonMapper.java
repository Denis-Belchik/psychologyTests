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
        answerPersonDTO.setReplay(answerPersonDTO.getReplay());
        answerPersonDTO.setTestId(answerPersonDTO.getTestId());
        answerPersonDTO.setReplacement(answerPersonDTO.getReplacement());
        return answerPersonDTO;
    }

    public AnswerPerson mapToEntity(AnswerPersonDTO answerPersonDTO) {
        AnswerPerson answerPerson = new AnswerPerson();
        answerPerson.setPositionAnswer(answerPersonDTO.getPositionAnswer());
        answerPerson.setUsername(answerPersonDTO.getUsername());
        answerPerson.setQuestionID(answerPersonDTO.getQuestionID());
        answerPerson.setReplay(answerPersonDTO.getReplay());
        answerPerson.setTestId(answerPersonDTO.getTestId());
        answerPerson.setReplacement(answerPersonDTO.getReplacement());
        return answerPerson;
    }

}