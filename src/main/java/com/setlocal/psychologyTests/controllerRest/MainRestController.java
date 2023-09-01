package com.setlocal.psychologyTests.controllerRest;

import com.setlocal.psychologyTests.dto.mainPage.MainPageForViewDTO;
import com.setlocal.psychologyTests.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Scope("session")
public class MainRestController {

    private final MainService mainService;

    @GetMapping("/rest")
    public ResponseEntity<MainPageForViewDTO> viewMainPage() {
        MainPageForViewDTO mainPageForViewDTO = mainService.getMainContent();
        return ResponseEntity.ok(mainPageForViewDTO);
    }

}
