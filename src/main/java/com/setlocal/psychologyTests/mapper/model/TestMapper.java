package com.setlocal.psychologyTests.mapper.model;

import com.setlocal.psychologyTests.dto.model.TestDTO;
import com.setlocal.psychologyTests.model.Test;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TestMapper {

    private final QuestionMapper questionMapper;

    public TestDTO mapToDto(Test test) {
        TestDTO testDto = new TestDTO();
        if (test != null) {
            testDto.setId(test.getId());
            testDto.setTitle(test.getTitle());
            testDto.setSize(test.getSize());
            testDto.setQuestions(test.getQuestions().stream()
                    .map(questionMapper::mapToDto)
                    .collect(Collectors.toList())
            );
        }
        return testDto;
    }

}
