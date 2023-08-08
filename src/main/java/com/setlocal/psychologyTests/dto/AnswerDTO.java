package com.setlocal.psychologyTests.dto;

import com.setlocal.psychologyTests.model.Answer;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDTO {
    private int id;
    private String answer;

    public static List<AnswerDTO> convertToListDto(List<Answer> answers) {
        return answers.stream()
                .map(a -> {
                    AnswerDTO answerDto = new AnswerDTO();
                    answerDto.setId(answers.indexOf(a) + 1);
                    answerDto.setAnswer(a.getAnswer());
                    return answerDto;
                })
                .collect(Collectors.toList());
    }
}
