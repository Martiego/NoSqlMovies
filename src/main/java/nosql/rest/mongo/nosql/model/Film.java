package nosql.rest.mongo.nosql.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@ToString
@Document(collection = "Film")
public class Film {
    @Id
    private ObjectId _id;
    private long budget;
    private String genres;
    private int id;
    private String keywords;
    private String original_language;
    private String original_title;
    private String overview;
    private double popularity;
    private String production_companies;
    private String production_countries;
    private Date release_date;
    private long revenue;
    private int runtime;
    private String spoken_languages;
    private String status;
    private String tagline;
    private String title;
    private double vote_average;
    private int vote_count;
}
