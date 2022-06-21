package nl.qnh.qforce.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonImpl implements Person {

    private long id;

    private String name;

    private String birthYear;

    private Gender gender;

    private int height;

    private int weight;

    private List<Movie> movies;

}
