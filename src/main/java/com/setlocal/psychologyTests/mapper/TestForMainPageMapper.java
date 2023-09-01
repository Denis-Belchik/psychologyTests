package com.setlocal.psychologyTests.mapper;

import com.setlocal.psychologyTests.dto.mainPage.TestForMainPageDTO;
import com.setlocal.psychologyTests.model.Test;
import org.springframework.stereotype.Component;

@Component
public class TestForMainPageMapper {

    public TestForMainPageDTO mapToDTO(Test test) {
        TestForMainPageDTO testForMainPageDTO = new TestForMainPageDTO();
        testForMainPageDTO.setId(test.getId());
        testForMainPageDTO.setTitle(test.getTitle());
        testForMainPageDTO.setDescription(test.getDescription());
        return testForMainPageDTO;
    }

}
