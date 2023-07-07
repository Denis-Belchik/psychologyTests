package com.setlocal.psychologyTests.controller;

import com.setlocal.psychologyTests.model.Question;
import com.setlocal.psychologyTests.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuestionController {

    private final TestService testService;

    public QuestionController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/")
    public String main() {
        testService.setTestRunning(true);
        return "test-start";
    }

    @GetMapping("/test-view")
    public String viewTest(Model model) {
//        System.out.println("get");
        if (!testService.isTestRunning())
            return "redirect:/";

        Question question = testService.getQuestion();
        if (question != null) {
            model.addAttribute("title", testService.getTitle());
            model.addAttribute("quest", question.getBody());
            model.addAttribute("answers", question.getListAnswers());
            return "test-view";
        }

        model.addAttribute("summ", testService.getValueAnswer());
        return "test-end";
    }

    @PostMapping("/test-post")
    public String viewTestNext(Integer id) {
//        System.out.println("post");
        if (!testService.isTestRunning())
            return "redirect:/";
        testService.nextIDQuest();
        testService.setValueAnswer(id);
        return "redirect:/test-view";
    }

}