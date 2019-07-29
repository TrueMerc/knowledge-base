package ru.ryabtsev.knowledgebase.flows.user.registration;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.ryabtsev.knowledgebase.validation.FieldMatch;
import ru.ryabtsev.knowledgebase.validation.ValidEmail;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * Implements user registration data.
 */
@Data
@NoArgsConstructor
@FieldMatch(first="password", second="matchingPassword", message="The passwords field must match.")
public class UserRegistrationData implements Serializable {

    private static final String REQUIRED_FIELD_MESSAGE = "This field is required.";
    private static final int NAME_FIELD_MINIMAL_SIZE = 3;
    private static final String LOGIN_TOO_SHORT_MESSAGE = "Login field must be at least " + NAME_FIELD_MINIMAL_SIZE + " symbols";

    @NotNull(message = REQUIRED_FIELD_MESSAGE)
    @Size(min = NAME_FIELD_MINIMAL_SIZE, message = LOGIN_TOO_SHORT_MESSAGE)
    private String login;

    @NotNull(message = REQUIRED_FIELD_MESSAGE)
    @Size(min = 1, message = "is required")
    private String password;

    @NotNull(message = REQUIRED_FIELD_MESSAGE)
    @Size(min = 1, message = "is required")
    private String matchingPassword;

    @NotNull(message = REQUIRED_FIELD_MESSAGE)
    @Size(min = 1, message = "is required")
    private String firstName;

    @NotNull(message = REQUIRED_FIELD_MESSAGE)
    @Size(min = 1, message = "is required")
    private String lastName;

    @NotNull(message = REQUIRED_FIELD_MESSAGE)
    @Size(min=10, message = "is required")
    private String phone;

    @ValidEmail
    @NotNull(message = REQUIRED_FIELD_MESSAGE)
    private String email;

    @NotNull(message = "is required")
    private List<Long> roleIds;
}
