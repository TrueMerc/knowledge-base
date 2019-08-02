package ru.ryabtsev.knowledgebase.flows;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.ryabtsev.knowledgebase.flows.user.registration.UserRegistrationHandler;
import ru.ryabtsev.knowledgebase.services.RoleService;
import ru.ryabtsev.knowledgebase.services.UserService;

@Configuration
public class FlowHandlersConfiguration {
    @Bean
    public UserRegistrationHandler userRegistrationHandler(final UserService userService, final RoleService roleService) {
        return new UserRegistrationHandler(userService, roleService);
    }
}
