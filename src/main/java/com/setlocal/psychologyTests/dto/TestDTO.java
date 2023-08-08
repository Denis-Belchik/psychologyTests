package com.setlocal.psychologyTests.dto;

import com.setlocal.psychologyTests.model.Test;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestDTO {
    private int id;
    private String title;
    private int length;
    private List<QuestionDTO> questions;

    public static TestDTO convertToDto(Test test) {
        TestDTO testDto = new TestDTO();
        if (test != null) {
            testDto.setId(test.getId());
            testDto.setTitle(test.getTitle());
            testDto.setQuestions(QuestionDTO.convertToListDto(test.getQuestions()));
            testDto.setLength(test.getQuestions().size());
        }
        return testDto;
    }
}
