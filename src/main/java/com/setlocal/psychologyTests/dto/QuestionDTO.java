package com.setlocal.psychologyTests.dto;

import com.setlocal.psychologyTests.model.Question;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class QuestionDTO implements MapToDTO<QuestionDTO, Question>{
    private int id;
    private String body;
    private Question.TypeAnswer type;
    private List<AnswerDTO> answers;

    @Override
    public QuestionDTO convertToDto(Question question) {
        QuestionDTO questionDto = new QuestionDTO();

        if (question != null) {
            questionDto.setId(question.getId());
            questionDto.setBody(question.getBody());
            questionDto.setType(question.getType());
            questionDto.setAnswers(question.getAnswers().stream()
                    .map(a -> new AnswerDTO().convertToDto(a))
                    .collect(Collectors.toList())
            );
        }

        return questionDto;
    }
}