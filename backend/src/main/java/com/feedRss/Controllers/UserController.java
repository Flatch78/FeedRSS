package com.feedRss.Controllers;

import com.feedRss.Dao.UserRepository;
import com.feedRss.Models.User;
import com.feedRss.Models.UserLogin;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;

/**
 * Created by edouard on 22/01/17.
 */
@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUser(@RequestHeader String token) {
        User user = userRepository.findByToken(token);
        user.setToken("");
        return user;
    }

    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public User putUser(@RequestHeader String token, @RequestBody UserLogin newUser) throws ServletException {
        User user = userRepository.findByToken(token);
        user.setToken("");

        if (newUser != null) {
            if (newUser.getName() != null
                    && newUser.getName().length() > 0
                    && userRepository.findByName(newUser.getName()).size() == 0) {
                user.setName(newUser.getName());
            } else {
                throw new ServletException("Invalid login");
            }
            if (newUser.getPassword() != null) {
                user.setToken(Jwts.builder().setSubject(newUser.name+newUser.password)
                        .signWith(SignatureAlgorithm.HS256, "secretkey").compact());
            } else {
                throw new ServletException("Invalid login/password");
            }
            userRepository.save(user);
        }
        return user;
    }

    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public String deleteUserById(@RequestHeader String token) {
        userRepository.deleteByToken(token);
        return "{ success:true }";
    }

}

