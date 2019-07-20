package ru.ryabtsev.knowledgebase.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ryabtsev.knowledgebase.entities.Role;
import ru.ryabtsev.knowledgebase.repositories.RoleRepository;
import ru.ryabtsev.knowledgebase.services.RolesService;

@Service
public class JpaRolesService implements RolesService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findById(final Long id) {
        return roleRepository.findOneById(id);
    }

    @Override
    public Role findByName(final String name) {
        return roleRepository.findOneByName(name);
    }
}
