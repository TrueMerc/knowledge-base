package ru.ryabtsev.knowledgebase.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdministratorController {

    @GetMapping("")
    public String administratorHome() {
        return "admin-panel";
    }
}
