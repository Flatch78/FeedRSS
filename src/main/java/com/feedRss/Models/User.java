package com.feedRss.Models;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;

/**
 * Created by leo on 19/01/2017.
 */
public class User {

    @Id
    private String id;

    private String name;
    private String token;
    private ArrayList<String> rssId;

    public User() {
        this.rssId = new ArrayList<>();
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.rssId = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
