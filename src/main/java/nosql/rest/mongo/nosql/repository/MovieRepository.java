package nosql.rest.mongo.nosql.repository;

import nosql.rest.mongo.nosql.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, Integer> {
}
