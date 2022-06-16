package nl.qnh.qforce.mapper;

import nl.qnh.qforce.api.consumed.swapi.SwapiPerson;
import nl.qnh.qforce.domain.QforcePerson;
import nl.qnh.qforce.domain.Gender;
import org.mapstruct.*;

@Mapper
public interface PersonMapper {

    @Mapping(target = "weight", source = "mass")
    @Mapping(target = "id", ignore = true)
    QforcePerson swapiToQforce(SwapiPerson swapiPerson);

    @ValueMappings({
            @ValueMapping(target = "MALE", source = "male"),
            @ValueMapping(target = "FEMALE", source = "female"),
            @ValueMapping(target = "NOT_APPLICABLE", source = "n/a"),
            @ValueMapping(target = "UNKNOWN", source = MappingConstants.ANY_REMAINING)
    })
    Gender toGender(String gender);
}
