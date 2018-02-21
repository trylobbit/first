package com.kasia.domain.products;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;
    private String lastName;
    private String mailAdress;
    private Adress houseAdress;
    private String password;



    public User(){

    }



    public User(String lastName, String mailAdress, Adress houseAdress, String password) {
        this.lastName = lastName;
        this.mailAdress = mailAdress;
        this.houseAdress = houseAdress;

    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMailAdress(String mailAdress) {
        this.mailAdress = mailAdress;
    }

    public void setHouseAdress(Adress houseAdress) {
        this.houseAdress = houseAdress;
    }

    public String getName() {

        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMailAdress() {
        return mailAdress;
    }

    public Adress getHouseAdress() {
        return houseAdress;
    }
}
