package ru.ryabtsev.knowledgebase.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.ryabtsev.knowledgebase.entities.User;
import ru.ryabtsev.knowledgebase.flows.user.registration.UserRegistrationData;

import java.util.List;

/**
 * Provides interface for users management service.
 */
public interface UserService extends UserDetailsService {

    /**
     * Returns user with given identifier if user exists.
     * @param id user identifier.
     * @return user with given identifier.
     */
    User findById(Long id);

    User findByLogin(final String login);

    /**
     * Saves user with given registration data if user with same login doesn't exist.
     * @param data user registration data
     * @return true if operation is successful and false in other case.
     */
    boolean save(final UserRegistrationData data);

    /**
     * Removes user with given identifier.
     * @param id user identifier.
     */
    void delete(final Long id);

    /**
     * Returns the list of all users.
     * @return the list of all users.
     */
    List<User> getAll();
}
