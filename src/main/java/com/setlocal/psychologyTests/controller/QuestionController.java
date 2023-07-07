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

    private int flag = 0;

    public QuestionController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/")
    public String startTest(Model model) {
        return "testStart";
    }

    @GetMapping("/testView")
    public String viewTest(Model model) {
        Question question = testService.getNextQuestion();
        if (question != null) {
            model.addAttribute("title", testService.getTitle());
            model.addAttribute("quest", question.getBody());
            model.addAttribute("answers", question.getListAnswers());
            model.addAttribute("summ", testService.getValueAnswer());
            return "testView";
        }
        model.addAttribute("summ", testService.getValueAnswer());
        return "testEnd";
    }

    @PostMapping("/testPost")
    public String viewTestNext(Integer id, Model model) {
        System.out.println(id);
        testService.setValueAnswer(id);
        return "redirect:/testView";
    }

//    @PostMapping("/testEnd")
//    public String viewTestNext(Model model) {
//        System.out.println("testService.getValueAnswer() = " + testService.getValueAnswer());
//        model.addAttribute("summ", testService.getValueAnswer());
//        return "testEnd";
//    }

}
