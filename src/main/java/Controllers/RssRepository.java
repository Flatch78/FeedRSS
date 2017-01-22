package Controllers;

import Models.Rss;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by leo on 19/01/2017.
 */
@RepositoryRestResource(collectionResourceRel = "rss", path = "rss")
public interface RssRepository extends MongoRepository<Rss, String> {

    Rss findById(@Param("id") String id);
    List<Rss> findByUrl(@Param("url") String url);

    Long deleteById(@Param("id") String id);
    Long deleteRssById(@Param("id") String id);

}
