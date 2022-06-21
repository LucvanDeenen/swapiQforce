package nl.qnh.qforce.api.consumed.swapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Locale;


/**
 * Entry point to map the data from SWAPI to
 * a class format and handle the data conversion
 * <p>
 * Applied JsonProperty to supply altered the naming
 * from the received JSON format
 * <p>
 * In case the key values are changed the JsonProperty
 * needs to be altered to handle this change. This way
 * the naming conventions received with snake case are
 * also not necessary.
 */

@Getter
@Setter
@NoArgsConstructor
public class SwapiPerson {

    private String name;

    private String height;

    private String mass;

    @JsonProperty("hair_color")
    private String hairColor;

    @JsonProperty("skin_color")
    private String skinColor;

    @JsonProperty("eye_color")
    private String eyeColor;

    @JsonProperty("birth_year")
    private String birthYear;

    private String gender;

    @JsonProperty("homeworld")
    private String homeWorld;

    private List<String> films;

    private List<String> species;

    private List<String> vehicles;

    private List<String> starships;

    private String created;

    private String edited;

    private String url;

}
