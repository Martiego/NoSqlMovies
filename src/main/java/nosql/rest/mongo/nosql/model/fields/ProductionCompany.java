package nosql.rest.mongo.nosql.model.fields;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProductionCompany {
    private int id;
    private String name;
}
