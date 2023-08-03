package com.setlocal.psychologyTests.dto;

import com.setlocal.psychologyTests.model.Question;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuestionDto {
    private int id;
    private String bodyQuestion;
    private Question.TypeAnswer type;
    private List<AnswerDto> answers;

    public static List<QuestionDto> convertToListDto(List<Question> question) {
        return question.stream().map(q -> {
                    QuestionDto questionDto = new QuestionDto();
                    questionDto.setId(q.getId());
                    questionDto.setBodyQuestion(q.getBodyQuestion());
                    questionDto.setType(q.getType());
                    questionDto.setAnswers(AnswerDto.convertToListDto(q.getAnswers()));
                    return questionDto;
                })
                .collect(Collectors.toList());
    }
}
