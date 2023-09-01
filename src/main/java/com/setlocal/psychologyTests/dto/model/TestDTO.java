package com.setlocal.psychologyTests.dto.model;

import com.setlocal.psychologyTests.dto.MapToDTO;
import com.setlocal.psychologyTests.model.Test;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class TestDTO implements MapToDTO<TestDTO, Test> {
    private int id;
    private String title;
    private int size;
    private List<QuestionDTO> questions;

    @Override
    public TestDTO convertToDto(Test test) {
        TestDTO testDto = new TestDTO();
        if (test != null) {
            testDto.setId(test.getId());
            testDto.setTitle(test.getTitle());
            testDto.setSize(test.getSize());
            testDto.setQuestions(test.getQuestions().stream()
                    .map(q -> new QuestionDTO().convertToDto(q))
                    .collect(Collectors.toList())
            );
        }
        return testDto;
    }
}
