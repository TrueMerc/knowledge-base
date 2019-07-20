package ru.ryabtsev.knowledgebase.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ryabtsev.knowledgebase.entities.User;
import ru.ryabtsev.knowledgebase.services.RolesService;
import ru.ryabtsev.knowledgebase.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private RolesService rolesService;

    @RequestMapping("/list")
    public String showUsersList(final Model model) {
        List<User> allUsers = userService.getAll();
        model.addAttribute("usersList", allUsers );
        return "users-list";
    }

    @RequestMapping("/addUser")
    public String addUser(final Model model) {
        return "flows/user/registration-form";
    }
}
