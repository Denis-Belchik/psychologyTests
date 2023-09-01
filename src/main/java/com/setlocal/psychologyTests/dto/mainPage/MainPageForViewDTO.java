package com.setlocal.psychologyTests.dto.mainPage;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MainPageForViewDTO {

    private PersonForMainPageDTO personForMainPageDTO;
    private List<TestForMainPageDTO> testForMainPageDTOList;

}
