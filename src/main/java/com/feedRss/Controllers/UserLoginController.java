package com.feedRss.Controllers;

import com.feedRss.Dao.UserRepository;
import com.feedRss.Models.User;
import com.feedRss.Models.UserLogin;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;


/**
 * Created by edouard on 24/01/17.
 */

@Controller
@RequestMapping("/")
public class UserLoginController {

    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @RequestMapping(value = "register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User register(@RequestBody UserLogin login) throws ServletException {
        if (login.name == null || userRepository.findByName(login.name).size() > 0) {
            throw new ServletException("Invalid login");
        }

        String token = Jwts.builder().setSubject(login.name+login.password)
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
        User user = new User();
        user.setName(login.name);
        user.setToken(token);
        userRepository.insert(user);
        return user;
    }

    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User login(@RequestBody UserLogin login) throws ServletException {
        if (login == null || login.name == null || userRepository.findByName(login.name).size() == 0)
            throw new ServletException("Invalid login/password");
        String token = Jwts.builder().setSubject(login.name+login.password)
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

        if (login.password == null || !userRepository.findByName(login.name).get(0).getToken().contains(token))
            throw new ServletException("Invalid login/password");

        return userRepository.findByName(login.name).get(0);
    }

    @SuppressWarnings("unused")
    private static class LoginResponse {
        public String token;

        public LoginResponse(final String token) {
            this.token = token;
        }
    }
}
