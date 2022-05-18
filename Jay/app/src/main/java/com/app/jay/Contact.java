package com.app.jay;

import java.io.Serializable;

public class Contact implements Serializable {

    private String gender, name, surname, dOBirth, telephone ,
            mail, postalC, city;
    private int imageId = R.drawable.image_contact;

    public Contact(){
    }

    public Contact(String gender, String name, String surname, String telephone) {
        this();
        this.gender = gender;
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
    }

    public Contact(String gender, String name, String surname, String telephone, String dOBirth,
                   String mail, String postalC, String city){
        this(gender, name, surname, telephone);
        this.dOBirth = dOBirth;
        this.mail = mail;
        this.postalC = postalC;
        this.city = city;
    }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getTxtName() { return name; }
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

    public int getImageId() { return imageId; }
    public void setImageId(String ImageId){ this.imageId = imageId; }

    @Override
    public String toString(){
        return ignoreNull(this.surname)+ ignoreNull(this.name)+
                ignoreNull(this.gender)+ ignoreNull(this.telephone)+
                        ignoreNull(this.dOBirth)+  ignoreNull(this.mail)+
                                ignoreNull(this.postalC)+ ignoreNull(this.city.toString());
    }

    private String ignoreNull(String str){
        return (str ==null | str.equals("") | str.isEmpty()) ? "" : (str+"\n");
    }
}
