package com.setlocal.psychologyTests.controller;

import com.setlocal.psychologyTests.dto.mainPage.MainPageForViewDTO;
import com.setlocal.psychologyTests.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@RequiredArgsConstructor
@Controller
@Scope("session")
public class MainController {

    private final MainService mainService;

    @GetMapping("/")
    public String viewMainPage(Model model) {
        MainPageForViewDTO mainPageForViewDTO = mainService.getMainContent();
        model.addAttribute("attribute", mainPageForViewDTO);
        return "test-start";
    }

}
