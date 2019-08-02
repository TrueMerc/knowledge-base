package ru.ryabtsev.knowledgebase.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ryabtsev.knowledgebase.entities.Role;


/**
 * Provides interface for repository which manipulates 'Role' ru.ryabtsev.entities.
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findOneById(final Long id);

    Role findOneByName(final String name);
}
