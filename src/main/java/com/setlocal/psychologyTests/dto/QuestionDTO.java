package com.setlocal.psychologyTests.dto;

import com.setlocal.psychologyTests.model.Question;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
    private int id;
    private String bodyQuestion;
    private Question.TypeAnswer type;
    private List<AnswerDTO> answers;

    public static List<QuestionDTO> convertToListDto(List<Question> question) {
        return question.stream().map(q -> {
                    QuestionDTO questionDto = new QuestionDTO();
                    questionDto.setId(q.getId());
                    questionDto.setBodyQuestion(q.getBodyQuestion());
                    questionDto.setType(q.getType());
                    questionDto.setAnswers(AnswerDTO.convertToListDto(q.getAnswers()));
                    return questionDto;
                })
                .collect(Collectors.toList());
    }
}
