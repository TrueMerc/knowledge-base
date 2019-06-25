package ru.ryabtsev.knowledgebase.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.ryabtsev.knowledgebase.entities.User;

import java.util.List;

/**
 * Provides interface for users management service.
 */
public interface UserService extends UserDetailsService {

    User findById(Long id);

    User findByLogin(final String login);

    boolean save(final User systemUser);

    void delete(Long id);

    List<User> findAll();
}
