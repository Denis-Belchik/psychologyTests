package com.setlocal.psychologyTests.controller;

import com.setlocal.psychologyTests.dto.model.AnswerPersonDTO;
import com.setlocal.psychologyTests.service.TestResultService;
import com.setlocal.psychologyTests.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Scope("session")
@RequiredArgsConstructor
public class QuestionController {

    @Value(value = "Предыдущий")
    private String buttonPref;
    @Value(value = "Следующий")
    private String buttonNext;
    @Value(value = "Закончить")
    private String buttonEnd;

    private final QuestionService questionService;
    private final TestResultService testResultService;

    @GetMapping("/test-view")
    public String viewTest(Model model) {
        if (!questionService.isRun())
            return "redirect:/";
        model.addAttribute("attribute", questionService.getViewTest());
        model.addAttribute("buttonNext", buttonNext);
        model.addAttribute("buttonPref", buttonPref);
        model.addAttribute("buttonEnd", buttonEnd);
        return "test-view";
    }

    @GetMapping("/test-end")
    public String endTest(Model model) {
        if (!questionService.isRun())
            return "redirect:/";
        model.addAttribute("resultQuest", testResultService.getResultQuest());
        return "test-end";
    }

    @PostMapping("/test-post-start")
    public String testPostStart(Integer id) {
        questionService.testRun(id);
        return "redirect:/test-view";
    }

    @PostMapping("/test-post-end")
    public String testPostEnd() {
        if (!questionService.isRun())
            return "redirect:/";
        questionService.testStop();
        testResultService.resultClear();
        return "redirect:/";
    }

    @PostMapping("/test-post-view")
    public String testPostNext(String button, AnswerPersonDTO answerPersonDTO) {
        if (!questionService.isRun()) {
            return "redirect:/";
        }

        if (button.equals(buttonNext)) {
            testResultService.addResult(answerPersonDTO);
            questionService.nextPosition();
        }

        if (button.equals(buttonPref)) {
            questionService.prefPosition();
        }

        if (button.equals(buttonEnd)) {
            testResultService.addResult(answerPersonDTO);
            return "redirect:/test-end";
        }

        return "redirect:/test-view";
    }

}