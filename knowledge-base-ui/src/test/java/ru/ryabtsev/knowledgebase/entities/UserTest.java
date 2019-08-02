package ru.ryabtsev.knowledgebase.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.ryabtsev.knowledgebase.entities.user.AuthenticationData;
import ru.ryabtsev.knowledgebase.entities.user.Contacts;
import ru.ryabtsev.knowledgebase.entities.user.NameData;

import java.util.Collections;

public class UserTest {

    private BCryptPasswordEncoder passwordEncoder;

    @Before
    public void init() {
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @Test
    public void createUserTest() {
        final String login = "user1";
        final String password = "password";
        final String firstName = "Ivan";
        final String lastName = "Ivanov";
        final String email = "ivanov@example.com";
        final String phone = "+7-777-777-77-77";
        Role role = new Role("ROLE_ADMIN");

        User user = new User(
            new AuthenticationData( login, password ),
            new NameData( firstName, lastName ),
            new Contacts( email, phone ),
            Collections.nCopies(1,  role )
        );

        Assert.assertEquals(user.getLogin(), login);
        Assert.assertEquals(user.getPassword(), password);
        Assert.assertEquals(user.getFirstName(), firstName);
        Assert.assertEquals(user.getLastName(), lastName);
        Assert.assertEquals(user.getEmail(), email);
        Assert.assertEquals(user.getPhone(), phone);
        Assert.assertTrue(user.getRoles().contains(role));
    }
}
