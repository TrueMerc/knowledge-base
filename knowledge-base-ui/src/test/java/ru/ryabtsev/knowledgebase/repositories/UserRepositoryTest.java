package ru.ryabtsev.knowledgebase.repositories;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ryabtsev.knowledgebase.entities.Role;
import ru.ryabtsev.knowledgebase.entities.User;
import ru.ryabtsev.knowledgebase.entities.user.AuthenticationData;
import ru.ryabtsev.knowledgebase.entities.user.Contacts;
import ru.ryabtsev.knowledgebase.entities.user.NameData;

import java.util.Collections;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserRepositoryTest {

    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void init() {
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @Test
    public void checkBeans() {
        Assert.assertNotNull(testEntityManager);
        Assert.assertNotNull(userRepository);
    }

    @Test
    public void userAdditionTest() {
        final String login = "admin";
        final String password = "password";
        final String firstName = "Ivan";
        final String lastName = "Ivanov";
        final String email = "ivanov@example.com";
        final String phone = "+7-777-777-77-77";
        Role role = new Role("ROLE_ADMIN");

        testEntityManager.persist(new User(
            new AuthenticationData( login, passwordEncoder.encode(password) ),
            new NameData( firstName, lastName ),
            new Contacts( email, phone ),
            Collections.nCopies(1, new Role("ROLE_ADMIN") )
        ));

        User user = userRepository.findOneByLogin("admin");
        Assert.assertNotNull(user);
        Assert.assertEquals(login, user.getLogin());
        Assert.assertTrue( user.getRoles().contains(role) );
    }
}
