package ru.ryabtsev.knowledgebase.entities;

import lombok.Data;
import ru.ryabtsev.knowledgebase.entities.user.AuthenticationData;
import ru.ryabtsev.knowledgebase.entities.user.Contacts;
import ru.ryabtsev.knowledgebase.entities.user.NameData;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "phone")
    private String phone;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    public User() {}

    public User(AuthenticationData authenticationData, NameData nameData, Contacts contacts, Collection<Role> roles) {
        this.login = authenticationData.getLogin();
        this.password = authenticationData.getPassword();
        this.firstName = nameData.getFirstName();
        this.lastName = nameData.getLastName();
        this.email = contacts.getEmail();
        this.phone = contacts.getPhone();
        this.roles = roles.stream().collect(Collectors.toList());
    }
}
