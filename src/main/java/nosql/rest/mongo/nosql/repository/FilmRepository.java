package nosql.rest.mongo.nosql.repository;

import nosql.rest.mongo.nosql.model.Film;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmRepository extends MongoRepository<Film, ObjectId> {
}
