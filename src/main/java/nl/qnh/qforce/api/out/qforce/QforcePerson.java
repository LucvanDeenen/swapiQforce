package nl.qnh.qforce.api.out.qforce;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import nl.qnh.qforce.domain.Gender;
import nl.qnh.qforce.domain.Movie;

import java.util.List;

@JsonPropertyOrder({"id", "name", "birth_year", "gender", "height", "weight", "movies"})
@Getter
@Setter
public class QforcePerson {

    private long id;

    private String name;

    @JsonProperty("birth_year")
    private String birthYear;

    private Gender gender;

    private int height;

    private int weight;

    private List<Movie> movies;

}
