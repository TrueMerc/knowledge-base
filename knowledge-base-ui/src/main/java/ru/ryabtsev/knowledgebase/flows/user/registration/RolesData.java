package ru.ryabtsev.knowledgebase.flows.user.registration;

import ru.ryabtsev.knowledgebase.entities.Role;
import ru.ryabtsev.knowledgebase.services.RoleService;

import java.io.Serializable;
import java.util.List;

/**
 * Contains data about knowledge base roles.
 */
public class RolesData implements Serializable {

    private final List<Role> roleList;

    RolesData(final RoleService rolesService) {
        roleList = rolesService.getAllRoles();
    }

    List<Role> getRoleList() {
        return roleList;
    }
}
