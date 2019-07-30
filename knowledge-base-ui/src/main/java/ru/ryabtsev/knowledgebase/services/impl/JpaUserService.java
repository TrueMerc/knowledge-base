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
import ru.ryabtsev.knowledgebase.entities.user.AuthenticationData;
import ru.ryabtsev.knowledgebase.entities.user.Contacts;
import ru.ryabtsev.knowledgebase.entities.user.NameData;
import ru.ryabtsev.knowledgebase.flows.user.registration.UserRegistrationData;
import ru.ryabtsev.knowledgebase.repositories.RoleRepository;
import ru.ryabtsev.knowledgebase.repositories.UserRepository;
import ru.ryabtsev.knowledgebase.services.UserService;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.LinkedList;
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
    public void delete(final Long id) {

    }

    @Override
    public List<User> getAll() {
        return (List<User>)userRepository.findAll();
    }

    @Override
    public User findById(final Long id) {
        return userRepository.findOneById(id);
    }

    @Override
    public User findByLogin(final String login) {
        return userRepository.findOneByLogin(login);
    }

    @Override
    @Transactional
    public boolean save(final UserRegistrationData data) {

        List<Role> roles = new LinkedList<>();
        for(Long id : data.getRoleIds() ) {
            roles.add( roleRepository.findOneById(id) );
        }

        User user = new User(
                new AuthenticationData( data.getLogin(), passwordEncoder.encode(data.getPassword())),
                new NameData( data.getFirstName(), data.getLastName() ),
                new Contacts( data.getEmail(), data.getPhone() ),
                roles
        );

        userRepository.save(user);
        return true;
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
