package com.feedRss.Dao;

import com.feedRss.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by leo on 19/01/2017.
 */
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByLastName(@Param("name") String name);
    List<User> findAll();
    User findById(@Param("id") String id);
    void delete(@Param("id") String id);
    User insert(@Param("user") User user);
}
