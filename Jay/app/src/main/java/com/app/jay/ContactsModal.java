package com.app.jay;

public class ContactsModal {

    // variables for our user name
    // and contact number.
    private String name;
    private String telephone;

    // constructor
    public ContactsModal(String name, String telephone) {
        this.name = name;
        this.telephone = telephone;
    }

    // getter and setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

}
