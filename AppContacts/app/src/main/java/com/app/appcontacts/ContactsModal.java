package com.app.appcontacts;

public class ContactsModal {

    // variables
    private String gender, name, surname, dOBirth, telephone , mail, postalC, city;

    // getters and setters
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getName() { return name; }
    public void setTxtName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public String getDOBirth() { return dOBirth; }
    public void setDOBirth(String dOBirth) { this.dOBirth = dOBirth; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }
    public String getPostalC() { return postalC; }
    public void setPostalC(String postalC) { this.postalC = postalC; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    // constructors
    public ContactsModal(){
    }

    public ContactsModal(String gender, String name, String surname, String telephone) {
        this();
        this.gender = gender;
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
    }

    // methode toString override
    @Override
    public String toString(){
        return this.name +"\n"+ this.surname
                +"\n"+ this.gender +"\n"+ this.telephone;
    }


}
