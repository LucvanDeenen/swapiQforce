package nl.qnh.qforce.api.out.qforce;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

public class QforceMovie {
    private String title;
    private int episode;
    private String director;
    @JsonProperty("release_date")
    private LocalDate releaseDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public Integer getEpisode() {
        return episode;
    }

    public void setEpisode(final int episode) {
        this.episode = episode;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(final String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(final LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

}
