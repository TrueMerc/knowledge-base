package ru.ryabtsev.knowledgebase.services;

import ru.ryabtsev.knowledgebase.entities.User;

import java.util.List;

/**
 * Provides interface for users management service.
 */
public interface UserService {

    User findById(Long id);

    User findByLogin(final String login);

    boolean save(final User systemUser);

    void delete(Long id);

    List<User> findAll();
}
