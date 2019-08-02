package ru.ryabtsev.knowledgebase.repositories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ryabtsev.knowledgebase.entities.Role;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class RoleRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void checkBeans() {
        Assert.assertNotNull(testEntityManager);
        Assert.assertNotNull(roleRepository);
    }

    @Test
    public void addRoleTest() {
        final String roleName = "ROLE_ADMIN";
        testEntityManager.persist(new Role(roleName));
        Role role = roleRepository.findOneByName(roleName);
        Assert.assertNotNull(role);
        Assert.assertEquals(roleName, role.getName());
    }
}
