package nosql.rest.mongo.nosql.model.fields;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductionCountry {
    private String iso_3166_1;
    private String name;
}
