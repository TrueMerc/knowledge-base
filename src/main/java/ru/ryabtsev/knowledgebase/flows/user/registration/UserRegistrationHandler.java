package ru.ryabtsev.knowledgebase.flows.user.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import ru.ryabtsev.knowledgebase.services.UserService;

public class UserRegistrationHandler {

    private static final String FAILURE = "failure";
    private static final String SUCCESS = "success";

    private final UserService userService;

    @Autowired
    public UserRegistrationHandler(UserService userService) {
        this.userService = userService;
    }

    public UserRegistrationModel init() {
        return new UserRegistrationModel();
    }

    public void addUserRegistrationData(final UserRegistrationModel model, final UserRegistrationData data) {
        model.setUserRegistrationData(data);
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
