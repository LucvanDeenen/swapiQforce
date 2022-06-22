package nl.qnh.qforce.api.consumed.swapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


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

//@Data
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

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(final String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(final String mass) {
        this.mass = mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(final String hairColor) {
        this.hairColor = hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(final String skinColor) {
        this.skinColor = skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(final String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(final String birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public String getHomeWorld() {
        return homeWorld;
    }

    public void setHomeWorld(final String homeWorld) {
        this.homeWorld = homeWorld;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(final List<String> films) {
        this.films = films;
    }

    public List<String> getSpecies() {
        return species;
    }

    public void setSpecies(final List<String> species) {
        this.species = species;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public void setVehicles(final List<String> vehicles) {
        this.vehicles = vehicles;
    }

    public List<String> getStarships() {
        return starships;
    }

    public void setStarships(final List<String> starships) {
        this.starships = starships;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(final String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(final String edited) {
        this.edited = edited;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }
}
