package Controllers;

import Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by leo on 19/01/2017.
 */
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByLastName(@Param("firstName") String firstName);

}
