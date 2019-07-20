package ru.ryabtsev.knowledgebase.flows.user.registration;

import java.io.Serializable;

public class UserRegistrationModel implements Serializable {

    private UserRegistrationData userRegistrationData;

    public void setUserRegistrationData(final UserRegistrationData userRegistrationData) {
        this.userRegistrationData = userRegistrationData;
    }

    public UserRegistrationData getUserRegistrationData() {
        return userRegistrationData;
    }
}
