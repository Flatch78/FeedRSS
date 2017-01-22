package com.feedRSS.Dao;

import com.feedRSS.Models.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by edouard on 22/01/17.
 */

@Repository
public class UserDao {

    private static Map<Integer, User> users;

    static {

        users = new HashMap<Integer, User>() {
            {
                put(1, new User(1, "edouard", "Marechal"));
                put(2, new User(2, "Guitou", "Gui"));
                put(3, new User(3, "All", "Alls"));
            }
        };
    }

    public Collection<User> getAllUsers() {
        return users.values();
    }

    public User getUserByid(int id) {
        return users.get(id);
    }

    public void removeUserById(int id) {
        users.remove(id);
    }

    public void updateUser(User userTmp) {
        User user = users.get(userTmp.getId());
        user.setFirstName(userTmp.getFirstName());
        user.setLastName(userTmp.getLastName());
        users.put(userTmp.getId(), user);
    }

    public void addUserToDb(User user) {
        users.put(user.getId(), user);
    }
}
