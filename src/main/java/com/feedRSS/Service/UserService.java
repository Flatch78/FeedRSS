package com.feedRSS.Service;

import com.feedRSS.Dao.UserDao;
import com.feedRSS.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by edouard on 22/01/17.
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Collection<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User getStudentById(int id) {
        return userDao.getUserByid(id);
    }

    public void removeUserById(int id) {
        userDao.removeUserById(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void addUser(User user) {
        userDao.addUserToDb(user);
    }
}
