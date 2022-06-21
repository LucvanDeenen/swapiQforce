package nl.qnh.qforce.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MovieImpl implements Movie {

    private String title;

    private int episode;

    private String director;

    private LocalDate releaseDate;

}
