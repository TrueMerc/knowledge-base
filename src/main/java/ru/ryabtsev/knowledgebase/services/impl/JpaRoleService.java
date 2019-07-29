package ru.ryabtsev.knowledgebase.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ryabtsev.knowledgebase.entities.Role;
import ru.ryabtsev.knowledgebase.repositories.RoleRepository;
import ru.ryabtsev.knowledgebase.services.RoleService;

import java.util.List;

@Service
public class JpaRoleService implements RoleService {

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

    @Override
    public List<Role> getAllRoles() {  return (List<Role>)roleRepository.findAll();  }
}
