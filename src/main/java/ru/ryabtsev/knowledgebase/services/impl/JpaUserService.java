package ru.ryabtsev.knowledgebase.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ryabtsev.knowledgebase.entities.Role;
import ru.ryabtsev.knowledgebase.entities.User;
import ru.ryabtsev.knowledgebase.repositories.RoleRepository;
import ru.ryabtsev.knowledgebase.repositories.UserRepository;
import ru.ryabtsev.knowledgebase.services.UserService;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implements users management service via JPA.
 */
@Service
public class JpaUserService implements UserService {

    private static final String USER_NAME_NOT_FOUND_MESSAGE = "Invalid login or password";

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
    @Transactional
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {
        User user = userRepository.findOneByLogin(login);
        if(null == user) {
            throw new UsernameNotFoundException(USER_NAME_NOT_FOUND_MESSAGE);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(), user.getPassword(), mapRolesToAuthorities(user.getRoles())
        );
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
