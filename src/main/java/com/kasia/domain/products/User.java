package com.kasia.domain.products;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    @NotEmpty(message = "*Please provide your name")
    private String name;
    @Column(name = "last_name")
    @NotEmpty
    private String lastName;
    @Column(name = "mail", unique = true)
    @NotEmpty
    @Email
    private String mailAdress;
    @Column(name = "password")
    @NotEmpty
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adress_id")
    private Adress adress;

    @Column(name = "role", nullable = false)
    @OneToMany(mappedBy = "users")
    private Set<Role> roles;

    @OneToMany(mappedBy = "user")
    private Set<Order> order;

    public User() {
    }

    public User(String lastName, String mailAdress, Adress adress, String password, int id) {
        this.lastName = lastName;
        this.mailAdress = mailAdress;
        this.adress = adress;
        this.password = password;
        this.id = id;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

 /*   public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }*/

    public Set<Order> getOrder() {
        return order;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
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
        this.adress = adress;
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

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, name='%s', lastName='%s', mailAdress='%s', password='%s']",
                id, name, lastName, mailAdress, password, adress.getCountry(), adress.getCity(), adress.getPostCode(), adress.getStreet(), adress.getHouseNumber());
    }


}