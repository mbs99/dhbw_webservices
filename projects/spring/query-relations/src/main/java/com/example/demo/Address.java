package com.example.demo;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private UUID id;
    private String zipCode;
    private String city;
    private String street;
    private String nr;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    User user;

    public UUID getId() {
        return id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
