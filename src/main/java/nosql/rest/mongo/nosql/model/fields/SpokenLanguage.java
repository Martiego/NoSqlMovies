package nosql.rest.mongo.nosql.model.fields;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SpokenLanguage {
    private String iso_639_1;
    private String name;
}
