package com.setlocal.psychologyTests.mapper.model;

import com.setlocal.psychologyTests.dto.model.QuestionDTO;
import com.setlocal.psychologyTests.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class QuestionMapper {

    private final AnswerMapper answerMapper;

    public QuestionDTO mapToDto(Question question) {
        QuestionDTO questionDto = new QuestionDTO();
        if (question != null) {
            questionDto.setId(question.getId());
            questionDto.setBody(question.getBody());
            questionDto.setType(question.getType());
            questionDto.setAnswers(question.getAnswers().stream()
                    .map(answerMapper::mapToDto)
                    .collect(Collectors.toList())
            );
        }
        return questionDto;
    }

}