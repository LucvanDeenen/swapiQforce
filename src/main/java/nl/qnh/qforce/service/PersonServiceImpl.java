package nl.qnh.qforce.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.qnh.qforce.api.consumed.swapi.SwapiMovie;
import nl.qnh.qforce.api.consumed.swapi.SwapiPerson;
import nl.qnh.qforce.api.consumed.swapi.SwapiResource;
import nl.qnh.qforce.domain.Gender;
import nl.qnh.qforce.domain.Person;
import nl.qnh.qforce.domain.PersonImpl;
import nl.qnh.qforce.mapper.PersonMapper;
import nl.qnh.qforce.mapper.PersonMapperImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    /**
     * Constructor with passing in the baseUrl from the resources file
     */
    public PersonServiceImpl(@Value("${swapi.baseUrl}") String baseUrl) {
        this.baseUrl = baseUrl;
    }
    private final PersonMapper personMapper = new PersonMapperImpl();

    /**
     * This could be placed into the PersonService interface
     * to generalize the functionality
     * <p>
     * param restTemplate Handles all the external API calls
     * return retrieved value in the form of Rest
     * <p>
     * param mapper Handles all Json formatting
     * return the read or written Json value
     */
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Parameters for setting up the targeted URI
     * <p>
     * param BASE_URL global declaration of URL
     * param target local specification of entry
     * param search searches Query appendix
     */
    private final String baseUrl;
    private final String target = "people/";
    private final String search = "?search=";

    /**
     * API Handlers methods
     */
    @Override
    public Optional<Person> get(long id) {
        final var URI = baseUrl + target + id;
//        getResource(URI, List<PersonImpl>);
        return Optional.empty();
    }
    @Override
    public List<Person> search(String query) {
        final var URI = baseUrl + target + search + query;

        final List<SwapiPerson> swapiPeople = objectMapper
                .convertValue(getResource(URI, new ArrayList<>()), new TypeReference<>() {});

        return convertPerson(swapiPeople);
    }

    /**
     * This method takes in a generic input and returns a LinkedHashMap
     * To handle this a conversion still has to be made
     */
    private <T> List<T> getResource(String uri, List<T> resources) {
        ResponseEntity<SwapiResource<T>> result = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        final var body = result.getBody();
        if (body == null) {
            return resources;
        }

        resources.addAll(body.getResults());
        if (body.getNext() == null) {
            return resources;
        } else {
            return getResource(body.getNext(), resources);
        }
    }

    /**
     * Converting SwapiPerson to Person using the MapStruct
     */
    private List<Person> convertPerson(List<SwapiPerson> swapiPeople) {
        final List<Person> personList = new ArrayList<>();

        for (SwapiPerson swapiPerson : swapiPeople) {
            final var swapiMovies = getMovies(swapiPerson.getFilms());
            PersonImpl personImpl = personMapper.swapiToPerson(swapiPerson, swapiMovies);
            personList.add(personImpl);
        }

        return personList;
    }

    private List<SwapiMovie> getMovies(List<String> movies) {

        final List<SwapiMovie> swapiMovies = new ArrayList<>();

        for (String movie : movies) {
            final var swapiMovie = restTemplate.getForObject(movie, SwapiMovie.class);
            swapiMovies.add(swapiMovie);
        }

        return swapiMovies;
    }
}
