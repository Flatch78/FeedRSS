package com.feedRss.Models;

/**
 * Created by edouard on 24/01/17.
 */
public class UserLogin {
    public String name;
    public String password;

    public UserLogin() {}

    public UserLogin(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
