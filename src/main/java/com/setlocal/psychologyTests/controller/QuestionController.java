package com.setlocal.psychologyTests.controller;

import com.setlocal.psychologyTests.dto.QuestionDTO;
import com.setlocal.psychologyTests.model.Test;
import com.setlocal.psychologyTests.service.PersonService;
import com.setlocal.psychologyTests.service.TestResultService;
import com.setlocal.psychologyTests.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("session")
@RequiredArgsConstructor
public class QuestionController {

    @Value(value = "${button.pref}")
    private String buttonPref;
    @Value(value = "${button.next}")
    private String buttonNext;
    @Value(value = "${button.end}")
    private String buttonEnd;

    private List<Test> testList = new ArrayList<>();

    private final TestService testService;
    private final TestResultService testResultService;
    private final PersonService personService;

    @GetMapping("/")
    public String main(Model model) {
        if (testList.isEmpty()) {
            testList = testService.getListTest();
        }
        model.addAttribute("titles", testList);
        model.addAttribute("personForViewDTO", personService.showUserInfo());
        return "test-start";
    }

    @GetMapping("/test-end")
    public String endTest(Model model) {
        if (!testService.isRun())
            return "redirect:/";
        model.addAttribute("resultQuest", testResultService.getResultQuest());
        return "test-end";
    }

    @GetMapping("/test-view")
    public String viewTest(Model model) {
        if (!testService.isRun())
            return "redirect:/";
        QuestionDTO questionDto = testService.getQuestion();
        if (questionDto != null) {
            model.addAttribute("title", testService.getTestTitle());
            model.addAttribute("quest", questionDto.getBodyQuestion());
            model.addAttribute("type", testService.getQuestionType());
            model.addAttribute("answers", questionDto.getAnswers());
            model.addAttribute("position", testService.getPosition());
            model.addAttribute("sizeTest", testService.getTestSize());
            model.addAttribute("buttonNext", buttonNext);
            model.addAttribute("buttonPref", buttonPref);
            model.addAttribute("buttonEnd", buttonEnd);
            return "test-view";
        }
        return "test-end";
    }

    @PostMapping("/test-post-start")
    public String testPostStart(Integer id) {
        testService.testRun(id);

        return "redirect:/test-view";
    }

    @PostMapping("/test-post-end")
    public String testPostEnd() {
        if (!testService.isRun())
            return "redirect:/";
        testService.testStop();
        testResultService.resultClear();
        return "redirect:/";
    }

    @PostMapping("/test-post-view")
    public String testPostNext(String button, Integer... id) {
        if (!testService.isRun())
            return "redirect:/";

        if (button.equals(buttonNext)) {
            testResultService.addResult(testService.getQuestion().getId(), id);
            testService.nextPosition();
        }
        if (button.equals(buttonPref))
            testService.prefPosition();

        if (button.equals(buttonEnd)) {
            testResultService.addResult(testService.getQuestion().getId(), id);
            return "redirect:/test-end";
        }
        return "redirect:/test-view";
    }

}