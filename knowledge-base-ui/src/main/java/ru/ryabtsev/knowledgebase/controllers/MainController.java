package ru.ryabtsev.knowledgebase.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private static final String MAIN_PAGE_NAME = "index";

    @GetMapping("/")
    public String mainPage(Model model) {
        return MAIN_PAGE_NAME;
    }

    @GetMapping("/index")
    public String indexPage(Model model) {
        return MAIN_PAGE_NAME;
    }
}
