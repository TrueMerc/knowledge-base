package ru.ryabtsev.knowledgebase.entities.user;

public class Contacts {
    private final String email;
    private final String phone;

    public Contacts(final String email, final String phone) {
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() { return email; }

    public String getPhone() { return phone; }
}
