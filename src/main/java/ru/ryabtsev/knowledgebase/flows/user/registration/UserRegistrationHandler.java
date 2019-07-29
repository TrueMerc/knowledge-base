package ru.ryabtsev.knowledgebase.flows.user.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import ru.ryabtsev.knowledgebase.services.RoleService;
import ru.ryabtsev.knowledgebase.services.UserService;

public class UserRegistrationHandler {

    private static final String FAILURE = "failure";
    private static final String SUCCESS = "success";

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserRegistrationHandler(final UserService userService, final RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    public UserRegistrationModel init() {
        return new UserRegistrationModel(roleService.getAllRoles());
    }

    public void modelHook(final UserRegistrationModel model) {
        final UserRegistrationModel m = model;;
    }

    public String validateUserRegistrationData(UserRegistrationData data, MessageContext error) {
        if (!data.getPassword().equals(data.getMatchingPassword())) {
            error.addMessage(new MessageBuilder()
                    .error()
                    .source("confirmPassword")
                    .defaultText("Password doesn't match up the confirm password!")
                    .build());

            return FAILURE;
        }
        return SUCCESS;
    }

    public String saveAll(UserRegistrationModel model, MessageContext error) {
        try {
            userService.save(model.getUserRegistrationData());
        } catch (Exception ex) {
            error.addMessage(new MessageBuilder()
                    .error()
                    .source("email")
                    .defaultText("Internal error. Can't complete registration.")
                    .build());
            return FAILURE;
        }
        return SUCCESS;
    }
}
