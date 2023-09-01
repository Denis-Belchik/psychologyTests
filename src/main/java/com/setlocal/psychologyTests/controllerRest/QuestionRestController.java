package com.setlocal.psychologyTests.controllerRest;

import com.setlocal.psychologyTests.dto.ViewTestDTO;
import com.setlocal.psychologyTests.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("session")
@RequiredArgsConstructor
public class QuestionRestController {

    private final QuestionService questionService;

    @GetMapping("/rest/test-view")
    public ResponseEntity<ViewTestDTO> viewTest() {
//        if (!questionService.isRun())
//            return "redirect:/";
        ViewTestDTO viewTestDTO = questionService.getViewTest();

        return ResponseEntity.ok(viewTestDTO);
    }

}
