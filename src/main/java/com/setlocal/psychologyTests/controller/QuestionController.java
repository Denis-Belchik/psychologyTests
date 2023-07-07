package com.setlocal.psychologyTests.controller;

import com.setlocal.psychologyTests.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuestionController {

    private final TestService testService;

    public QuestionController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/")
    public String viewTest(Model model){
        model.addAttribute("quest", testService.getQuestion(3).getBody());
        model.addAttribute("answers", testService.getQuestion(3).getAnswer());
        model.addAttribute("title", testService.getTitle());
        return "testView";
    }

}
