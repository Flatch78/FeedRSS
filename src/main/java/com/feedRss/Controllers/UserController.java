package com.feedRss.Controllers;

import com.feedRss.Dao.UserRepository;
import com.feedRss.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Created by edouard on 22/01/17.
 */
@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "users/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") String id) {
        return userRepository.findById(id);
    }

    @ResponseBody
    @RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable("id") String id) {
        userRepository.delete(id);
    }

    @ResponseBody
    @RequestMapping(value = "users/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody User user) {
        userRepository.insert(user);
    }

    @ResponseBody
    @RequestMapping(value = "users/me", method = RequestMethod.GET)
    public User getUser(@RequestHeader String id) {
        return userRepository.findById(id);
    }
}

