package nl.qnh.qforce.domain;

import javax.persistence.Entity;
import java.time.LocalDate;

public class MovieImpl implements Movie {
    private String title;
    private int episode;
    private String director;
    private LocalDate releaseDate;

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    @Override
    public Integer getEpisode() {
        return episode;
    }

    public void setEpisode(final int episode) {
        this.episode = episode;
    }

    @Override
    public String getDirector() {
        return director;
    }

    public void setDirector(final String director) {
        this.director = director;
    }

    @Override
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(final LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
