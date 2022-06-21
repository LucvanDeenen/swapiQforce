package nl.qnh.qforce.api.out.qforce;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class QforceMovie {

    private String title;

    private int episode;

    private String director;

    @JsonProperty("release_date")
    private LocalDate releaseDate;

}
