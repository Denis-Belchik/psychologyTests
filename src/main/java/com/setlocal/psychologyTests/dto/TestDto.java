package com.setlocal.psychologyTests.dto;

import com.setlocal.psychologyTests.model.Test;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TestDto {
    private int id;
    private String title;
    private int length;
    private List<QuestionDto> questions;

    public static TestDto convertToDto(Test test) {
        TestDto testDto = new TestDto();
        if (test != null) {
            testDto.setId(test.getId());
            testDto.setTitle(test.getTitle());
            testDto.setQuestions(QuestionDto.convertToListDto(test.getQuestions()));
            testDto.setLength(test.getQuestions().size());
        }
        return testDto;
    }
}
