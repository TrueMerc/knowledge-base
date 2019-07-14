package ru.ryabtsev.knowledgebase.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ryabtsev.knowledgebase.entities.User;
import ru.ryabtsev.knowledgebase.repositories.RoleRepository;
import ru.ryabtsev.knowledgebase.repositories.UserRepository;
import ru.ryabtsev.knowledgebase.services.UserService;

import java.util.List;

/**
 * Implements users management service via JPA.
 */
@Service
public class JpaUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User findById(final Long id) {
        return userRepository.findOneById(id);
    }

    @Override
    public User findByLogin(final String login) {
        return userRepository.findOneByLogin(login);
    }

    @Override
    public boolean save(final User systemUser) {
        return false;
    }

    @Override
    public void delete(final Long id) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(final String s) throws UsernameNotFoundException {
        return null;
    }
}
