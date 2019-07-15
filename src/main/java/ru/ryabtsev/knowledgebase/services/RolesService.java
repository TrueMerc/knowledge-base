package ru.ryabtsev.knowledgebase.services;

import org.springframework.stereotype.Service;
import ru.ryabtsev.knowledgebase.entities.Role;

/**
 * Provides interface for service which manages user roles.
 */
public interface RolesService {

    Role findById(final Long id);

    Role findByName(final String name);
}
