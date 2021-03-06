package ru.ryabtsev.knowledgebase.flows.user.registration;

import ru.ryabtsev.knowledgebase.entities.Role;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implements data model for user registration web flow.
 */
public class UserRegistrationModel implements Serializable {

    private UserRegistrationData userRegistrationData;
    private Map<Long, String> roleNamesMap;

    public UserRegistrationModel(final List<Role> roleList) {
        this.userRegistrationData = new UserRegistrationData();
        this.roleNamesMap = roleList.stream().collect( Collectors.toMap(r -> r.getId(), r -> r.getName()) );
    }

    public UserRegistrationData getUserRegistrationData() {
        return userRegistrationData;
    }

    public Map<Long, String> getRoleNamesMap() { return roleNamesMap; }
}
