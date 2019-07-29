package ru.ryabtsev.knowledgebase.services;


import ru.ryabtsev.knowledgebase.entities.Role;

import java.util.Collection;
import java.util.List;

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
