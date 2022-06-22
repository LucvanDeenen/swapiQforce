package nl.qnh.qforce.api.out.qforce;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import nl.qnh.qforce.domain.Gender;
import nl.qnh.qforce.domain.Movie;

import java.util.List;

//@Data
@JsonPropertyOrder({"id", "name", "birth_year", "gender", "height", "weight", "movies"})
public class PersonDTO {

    private long id;

    private String name;

    @JsonProperty("birth_year")
    private String birthYear;

    private Gender gender;

    private int height;

    private int weight;

    private List<Movie> movies;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(final String birthYear) {
        this.birthYear = birthYear;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(final Gender gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(final int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(final int weight) {
        this.weight = weight;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(final List<Movie> movies) {
        this.movies = movies;
    }
}
