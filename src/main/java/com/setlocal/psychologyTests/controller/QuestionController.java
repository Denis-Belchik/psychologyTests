package com.setlocal.psychologyTests.controller;

import com.setlocal.psychologyTests.dto.model.QuestionDTO;
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

    @GetMapping("/test-end")
    public String endTest(Model model) {
        if (!questionService.isRun())
            return "redirect:/";
        model.addAttribute("resultQuest", testResultService.getResultQuest());
        return "test-end";
    }

    @GetMapping("/test-view")
    public String viewTest(Model model) {
        if (!questionService.isRun())
            return "redirect:/";
        QuestionDTO questionDto = questionService.getQuestion();
        if (questionDto != null) {
            model.addAttribute("title", questionService.getTestTitle());
            model.addAttribute("quest", questionDto.getBody());
            model.addAttribute("type", questionService.getQuestionType());
            model.addAttribute("answers", questionDto.getAnswers());
            model.addAttribute("position", questionService.getPosition());
            model.addAttribute("sizeTest", questionService.getTestSize());
            model.addAttribute("buttonNext", buttonNext);
            model.addAttribute("buttonPref", buttonPref);
            model.addAttribute("buttonEnd", buttonEnd);
            return "test-view";
        }
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
    public String testPostNext(String button, Integer... id) {
        if (!questionService.isRun())
            return "redirect:/";

        if (button.equals(buttonNext)) {
            testResultService.addResult(questionService.getQuestion().getId(), id);
            questionService.nextPosition();
        }
        if (button.equals(buttonPref))
            questionService.prefPosition();

        if (button.equals(buttonEnd)) {
            testResultService.addResult(questionService.getQuestion().getId(), id);
            return "redirect:/test-end";
        }
        return "redirect:/test-view";
    }

}