package nl.qnh.qforce.api.out.qforce;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Data
public class MovieDTO {

    private String title;

    private int episode;

    private String director;

    @JsonProperty("release_date")
    private LocalDate releaseDate;

}
