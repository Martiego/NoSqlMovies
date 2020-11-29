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
@Document(collection = "Movie")
public class Movie {
    @Id
    private Integer id;
    private Long budget;
    private List<Genre> genres;
    private String homepage;
    private List<Keyword> keywords;
    private String original_language;
    private String original_title;
    private String overview;
    private Double popularity;
    private List<ProductionCompany> production_companies;
    private List<ProductionCountry> production_countries;
    private Date release_date;
    private Long revenue;
    private Integer runtime;
    private List<SpokenLanguage> spoken_languages;
    private String status;
    private String tagline;
    private String title;
    private Double vote_average;
    private Integer vote_count;
}
