package ru.ryabtsev.knowledgebase.entities.user;

public class AuthenticationData {
    private final String login;
    private final String password;

    public AuthenticationData(final String login, final String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() { return login; }

    public String getPassword() { return password; }
}
