package com.setlocal.psychologyTests.dto;

import com.setlocal.psychologyTests.model.Answer;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDto {
    private int id;
    private String answer;

    public static List<AnswerDto> convertToListDto(List<Answer> answers) {
        return answers.stream()
                .map(a -> {
                    AnswerDto answerDto = new AnswerDto();
                    answerDto.setId(answers.indexOf(a) + 1);
                    answerDto.setAnswer(a.getAnswer());
                    return answerDto;
                })
                .collect(Collectors.toList());
    }
}
