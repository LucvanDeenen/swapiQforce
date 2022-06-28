package nl.qnh.qforce.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MovieImpl implements Movie {

    private String title;

    private Integer episode;

    private String director;

    private LocalDate releaseDate;

}
