package ru.ryabtsev.knowledgebase.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ryabtsev.knowledgebase.entities.User;
import ru.ryabtsev.knowledgebase.services.RoleService;
import ru.ryabtsev.knowledgebase.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService rolesService;

    @RequestMapping("/list")
    public String showUsersList(final Model model) {
        List<User> allUsers = userService.getAll();
        model.addAttribute("usersList", allUsers );
        return "users-list";
    }

    @RequestMapping("/addUser")
    public String addUser(final Model model) {
        return "redirect:/registration";
    }

//    @PostMapping("/addUser")
//    public String addUser(@Valid UserRegistrationData data, BindingResult result, RedirectAttributes attributes) {
//        if( result.hasErrors()) {
//            return "users-list";
//        }
//        attributes.addAttribute("login", data.getLogin());
//
//        return "redirect:/registration";
//    }
}
