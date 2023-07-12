package com.setlocal.psychologyTests.controller;

import com.setlocal.psychologyTests.model.Question;
import com.setlocal.psychologyTests.service.TestResultServiceImpl;
import com.setlocal.psychologyTests.service.TestService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Scope("session")
public class QuestionController {

    private final TestService testService;

    private final TestResultServiceImpl testResultService;

    public QuestionController(TestService testService, TestResultServiceImpl testResultService) {
        this.testService = testService;
        this.testResultService = testResultService;
    }

    @GetMapping("/")
    public String main() {
        return "test-start";
    }

    @GetMapping("/test-view")
    public String viewTest(Model model) {
        if (!testService.isTestRunning())
            return "redirect:/";

        Question question = testService.getQuestion();
        if (question != null) {
            model.addAttribute("title", testService.getTitle());
            model.addAttribute("quest", question.getBodyQuestion());
            model.addAttribute("type", testService.getType());
            model.addAttribute("answers", question.getAnswersList());
            model.addAttribute("position", testService.getPosition());
            model.addAttribute("sizeTest", testService.getSize());
            return "test-view";
        }

        model.addAttribute("resultQuest", testResultService.getResultQuest());
        return "test-end";
    }

    @PostMapping("/test-run")
    public String viewTestRun(Integer id) {
        testService.testRun(id);
        return "redirect:/test-view";
    }

    @PostMapping("/test-end")
    public String viewTestEnd() {
        testService.testStop();
        return "redirect:/";
    }

    @PostMapping("/test-post")
    public String viewTestNext(String button, Model model, Integer... id) {
        if (!testService.isTestRunning())
            return "redirect:/";

        if (button.equals("Следующий")) {
            testResultService.addResult(testService.getQuestion().getIDQuestion(), id);
            testService.nextPosition();
        }
        if (button.equals("Предыдущий"))
            testService.prefPosition();

        if (button.equals("Закончить")) {
            testResultService.addResult(testService.getQuestion().getIDQuestion(), id);
            model.addAttribute("resultQuest", testResultService.getResultQuest());
            return "test-end";
        }

        return "redirect:/test-view";
    }

}