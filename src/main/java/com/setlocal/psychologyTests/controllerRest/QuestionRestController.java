package com.setlocal.psychologyTests.controllerRest;

import com.setlocal.psychologyTests.dto.ViewTestDTO;
import com.setlocal.psychologyTests.dto.model.AnswerPersonDTO;
import com.setlocal.psychologyTests.exception.TestNotRunException;
import com.setlocal.psychologyTests.service.QuestionService;
import com.setlocal.psychologyTests.service.TestResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@Scope("session")
@RequiredArgsConstructor
@RequestMapping("/rest")
public class QuestionRestController {

    @Value(value = "Предыдущий")
    private String buttonPref;
    @Value(value = "Следующий")
    private String buttonNext;
    @Value(value = "Закончить")
    private String buttonEnd;

    private final QuestionService questionService;
    private final TestResultService testResultService;

    @GetMapping("/test-view")
    public ResponseEntity<ViewTestDTO> viewTest() {
        ViewTestDTO viewTestDTO = questionService.getViewTest();
        return ResponseEntity.ok(viewTestDTO);
    }

    @GetMapping("/test-end")
    public ResponseEntity<Collection<List<Integer>>> endTest() {
        Collection<List<Integer>> collection = testResultService.getResultQuest();
        return ResponseEntity.ok(collection);
    }

    @PostMapping("/test-post-start")
    public void testPostStart(Integer id) {
        questionService.testRun(id);
    }

    @PostMapping("/test-post-end")
    public void testPostEnd() {
        questionService.testStop();
        testResultService.resultClear();
    }

    @PostMapping("/test-post-view")
    public ResponseEntity<ViewTestDTO> testPostNext(String button,
                                                    AnswerPersonDTO answerPersonDTO) {
        if (!questionService.isRun()) {
            throw new TestNotRunException("Тест не запущен");
        }

        if (button.equals(buttonNext) || button.equals(buttonEnd)) {
            testResultService.addResult(answerPersonDTO);
            questionService.nextPosition();
        }

        if (button.equals(buttonPref)) {
            questionService.prefPosition();
        }

        return ResponseEntity.ok(questionService.getViewTest());
    }

}