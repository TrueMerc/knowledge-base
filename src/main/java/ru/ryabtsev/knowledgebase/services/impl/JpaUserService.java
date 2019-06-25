package ru.ryabtsev.knowledgebase.services.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.ryabtsev.knowledgebase.entities.User;
import ru.ryabtsev.knowledgebase.services.UserService;

import java.util.List;

/**
 * Implements users management service via JPA.
 */
public class JpaUserService implements UserService {
    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User findByLogin(String login) {
        return null;
    }

    @Override
    public boolean save(User systemUser) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
