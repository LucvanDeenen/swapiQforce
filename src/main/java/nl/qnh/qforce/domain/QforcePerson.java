package nl.qnh.qforce.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import nl.qnh.qforce.domain.Gender;

import java.util.List;

public class QforcePerson {
    private long id;
    private String name;
    @JsonProperty("birth_year")
    private String birthYear;
    private Gender gender;
    private String height;
    private String weight;

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

    public String getHeight() {
        return height;
    }

    public void setHeight(final String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(final String weight) {
        this.weight = weight;
    }
}
