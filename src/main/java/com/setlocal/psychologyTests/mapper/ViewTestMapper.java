package com.setlocal.psychologyTests.mapper;

import com.setlocal.psychologyTests.dto.ViewTestDTO;
import com.setlocal.psychologyTests.dto.model.AnswerDTO;;
import com.setlocal.psychologyTests.model.Question;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ViewTestMapper {

    public ViewTestDTO mapToDTO(String question,
                                int position,
                                String title,
                                int size,
                                List<AnswerDTO> answers,
                                Question.TypeAnswer typeAnswer){
        ViewTestDTO viewTestDTO = new ViewTestDTO();
        viewTestDTO.setQuestion(question);
        viewTestDTO.setPosition(position);
        viewTestDTO.setTitle(title);
        viewTestDTO.setSize(size);
        viewTestDTO.setAnswers(answers);
        viewTestDTO.setTypeAnswer(typeAnswer);
        return viewTestDTO;
    }

}
