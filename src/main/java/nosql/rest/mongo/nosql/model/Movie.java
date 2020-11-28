package nosql.rest.mongo.nosql.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import nosql.rest.mongo.nosql.model.fields.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Document(collection = "MovieT")
public class Movie {
    @Id
    private ObjectId _id;
    private long budget;
    //TODO Kolekcje nie działają, IllegalArgumentException
    private List<Genre> genres;
    private String homepage;
    private int id;
//    private Keyword[] keywords;
    private String original_language;
    private String original_title;
    private String overview;
    private double popularity;
//    private ProductionCompany[] production_companies;
//    private ProductionCountry[] production_countries;
    // TODO trzeba przekonwertować datę ze stringa na date
    private Date release_date;
    private long revenue;
    private int runtime;
//    private SpokenLanguage[] spoken_languages;
    private String status;
    private String tagline;
    private String title;
    private double vote_average;
    private int vote_count;
}
