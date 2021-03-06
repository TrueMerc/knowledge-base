package ru.ryabtsev.knowledgebase.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ryabtsev.knowledgebase.entities.User;

/**
 * Provides interface for repository which manipulates 'User' ru.ryabtsev.entities.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findOneById(final Long id);

    User findOneByLogin(final String login);
}
