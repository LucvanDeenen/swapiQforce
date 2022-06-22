package nl.qnh.qforce.mapper;

import nl.qnh.qforce.api.consumed.swapi.SwapiMovie;
import nl.qnh.qforce.api.out.qforce.MovieDTO;
import nl.qnh.qforce.domain.Movie;
import nl.qnh.qforce.domain.MovieImpl;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MovieMapper {

    @Mapping(target = "episode", source = "episodeId")
    MovieImpl swapiToMovie(SwapiMovie swapiMovie);

    MovieDTO movieToQforce(Movie movie);

}
