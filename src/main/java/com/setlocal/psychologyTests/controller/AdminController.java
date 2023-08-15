package com.setlocal.psychologyTests.controller;

import com.setlocal.psychologyTests.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("session")
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final PersonService personService;

    @GetMapping("/view")
    public String admin() {
        return "admin/view";
    }

    @PostMapping("/view-person-post")
    public String viewPerson(Model model){
        model.addAttribute("infoperson", personService.getAllPersonDTO());
        return "admin/view";
    }

}
