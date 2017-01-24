package com.feedRss.Models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * Created by leo on 19/01/2017.
 */
public class User {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String token;

    public User() {}

    public User(String id, String lastName) {
        this.id = id;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }

    @Override
    public String toString() {
        return "User {" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName +
                "\'}";
    }
}
