package nl.qnh.qforce.domain;

import lombok.Data;

import java.util.List;

@Data
public class PersonImpl implements Person {

    private long id;

    private String name;

    private String birthYear;

    private Gender gender;

    private Integer height;

    private Integer weight;

    private List<Movie> movies;

}
