package com.feedRss.Models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

/**
 * Created by leo on 19/01/2017.
 */
public class User {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String token;
    private ArrayList<String> rssId;

    public User() {
        this.rssId = new ArrayList<>();
    }

    public User(String id, String lastName) {
        this.id = id;
        this.lastName = lastName;
        this.rssId = new ArrayList<>();
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

    public ArrayList<String> getRss() {
        return rssId;
    }

    public void setRss(ArrayList<String> rssId) {
        this.rssId = rssId;
    }

    public void addRss(String rssId) {
        this.rssId.add(rssId);
    }

    public void removeRss(String rssId) {
        this.rssId.remove(rssId);
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }



    @Override
    public String toString() {
        return "User {" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName +
                "\'}";
    }
}
