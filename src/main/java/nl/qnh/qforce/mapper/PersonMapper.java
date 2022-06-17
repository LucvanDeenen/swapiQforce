package nl.qnh.qforce.mapper;

import nl.qnh.qforce.api.consumed.swapi.SwapiMovie;
import nl.qnh.qforce.api.consumed.swapi.SwapiPerson;
import nl.qnh.qforce.domain.Gender;
import nl.qnh.qforce.domain.PersonImpl;
import org.mapstruct.*;

import java.util.List;

@Mapper(uses = MovieMapper.class)
public interface PersonMapper {

    @Mapping(target = "id", qualifiedByName = "urlToId", source = "swapiPerson.url")
    @Mapping(target = "weight", qualifiedByName = "integerConversion", source = "swapiPerson.mass")
    @Mapping(target = "height", qualifiedByName = "integerConversion")
    @Mapping(target = "movies", source = "swapiMovies")
    PersonImpl swapiToPerson(SwapiPerson swapiPerson, List<SwapiMovie> swapiMovies);

    @ValueMappings({
            @ValueMapping(target = "MALE", source = "male"),
            @ValueMapping(target = "FEMALE", source = "female"),
            @ValueMapping(target = "NOT_APPLICABLE", source = "n/a"),
            @ValueMapping(target = "UNKNOWN", source = MappingConstants.ANY_REMAINING)
    })
    Gender toGender(String genderString);

    @Named("integerConversion")
    default int toInt(String numValue) {
        try {
            return Integer.parseInt(numValue);
        } catch (NumberFormatException exception) {
            return 0;
        }
    }

    @Named("urlToId")
    default long toId(String url) {
        if (url == null) {
            return 0;
        }

        final var splitUri = url.split("/");
        return Long.parseLong(splitUri[splitUri.length - 1]);
    }
}
