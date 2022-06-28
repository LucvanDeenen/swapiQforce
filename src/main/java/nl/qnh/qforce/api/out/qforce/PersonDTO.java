package nl.qnh.qforce.api.out.qforce;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import nl.qnh.qforce.domain.Gender;

import java.util.List;

@Data
@JsonPropertyOrder({"id", "name", "birth_year", "gender", "height", "weight", "movies"})
public class PersonDTO {

    private long id;

    private String name;

    @JsonProperty("birth_year")
    private String birthYear;

    private Gender gender;

    private int height;

    private int weight;

    private List<MovieDTO> movies;

}
