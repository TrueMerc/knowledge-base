package ru.ryabtsev.knowledgebase.services;

import java.util.List;
import ru.ryabtsev.knowledgebase.entities.Role;

/**
 * Provides interface for service which manages user roles.
 */
public interface RoleService {

    Role findById(final Long id);

    Role findByName(final String name);

    /**
     * Returns a list of all accessible roles.
     * @return a list of all accessible roles.
     */
    List<Role> getAllRoles();
}
