package ru.ryabtsev.knowledgebase.entities.user;

public class NameData {
    private final String firstName;
    private final String lastName;

    public NameData(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() { return firstName;  }

    public String getLastName() { return lastName; }
}
