package com.feedRss.Dao;

import com.feedRss.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by leo on 19/01/2017.
 */
@RequestMapping("/api")
@RepositoryRestResource(collectionResourceRel = "users", path = "user"/*, exported = false*/)
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByName(@Param("name") String name);
    List<User> findAll();
    User findById(@Param("id") String id);
    User findByToken(@Param("token") String token);
    void deleteByToken(@Param("token") String token);
    User insert(@Param("user") User user);
}
