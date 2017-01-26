package com.feedRss.Controllers;

import com.feedRss.Dao.RssRepository;
import com.feedRss.Dao.UserRepository;

import com.feedRss.Models.Rss;
import com.feedRss.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edouard on 22/01/17.
 */
@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RssRepository rssRepository;

    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        users = userRepository.findAll();
        for (int i = 0; i < users.size(); i++)
            users.get(i).setToken("");
        return users;
    }

    @ResponseBody
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") String id) {
        return userRepository.findById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public String deleteUserById(@PathVariable("id") String id) {
        userRepository.delete(id);
        return "{ success:true }";
    }

    @ResponseBody
    @RequestMapping(value = "/users/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody User user) {
        userRepository.insert(user);
    }

    @ResponseBody
    @RequestMapping(value = "/users/me", method = RequestMethod.GET)
    public User getUser(@RequestHeader String token) {
        User user = userRepository.findByToken(token);
        user.setToken("");
        return user;
    }
    @ResponseBody
    @RequestMapping(value = "/users/rss", method = RequestMethod.GET)
    public List<Rss> getUserRss(@RequestHeader String token) {
        User user = userRepository.findByToken(token);
        List<Rss> listRss = new ArrayList<>();
        if (rssRepository.findAll().size() > 0) {
            for (String id : user.getRss()) {
                listRss.add(rssRepository.findById(id));
            }
        }
        return listRss;
    }
}

