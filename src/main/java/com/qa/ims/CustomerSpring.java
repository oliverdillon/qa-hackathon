package com.qa.ims;

public class CustomerSpring {

    private final Long id;
    private final String firstName;
    private final String surname;
    private final String emailAddress;
    private final String phoneNumber;

    public CustomerSpring(Long id, String firstName, String surname, String emailAddress, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }
    public Long getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
