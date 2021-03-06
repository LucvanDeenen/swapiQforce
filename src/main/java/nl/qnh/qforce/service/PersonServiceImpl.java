package nl.qnh.qforce.service;

import nl.qnh.qforce.api.consumed.swapi.SwapiMovie;
import nl.qnh.qforce.api.consumed.swapi.SwapiPerson;
import nl.qnh.qforce.api.consumed.swapi.SwapiResource;
import nl.qnh.qforce.api.out.qforce.PersonDTO;
import nl.qnh.qforce.domain.Person;
import nl.qnh.qforce.mapper.PersonMapper;
import nl.qnh.qforce.mapper.PersonMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final LogService logService;

    @Autowired
    public PersonServiceImpl(@Value("${swapi.baseUrl}") String baseUrl, LogService logService) {
        this.baseUrl = baseUrl;
        this.logService = logService;
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

    /**
     * Parameters for setting up the targeted URI
     * <p>
     * param BASE_URL global declaration of URL
     * param target local specification of entry
     * param search searches Query appendix
     */
    private final String baseUrl;
    private final String target = "people/";

    /**
     * API Handlers methods
     */
    @Override
    public Optional<Person> get(long id) {

        final var uri = baseUrl + target + id;

        final SwapiPerson swapiPerson = searchPerson(uri);

        final var person = convertPerson(swapiPerson);

        return Optional.of(person);
    }

    private SwapiPerson searchPerson(String uri) {
        final var res = restTemplate
                .exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<SwapiPerson>() {
                });

        return res.getBody();
    }

    public PersonDTO transformPerson(Person person) {
        return personMapper.personToQforce(person, person.getMovies());
    }

    @Override
    public List<Person> search(String query) {

        String search = "?search=";
        final var uri = baseUrl + target + search + query;

        final List<SwapiPerson> swapiPersons = searchPersons(uri, new ArrayList<>());

        final var persons = new ArrayList<Person>();

        for (SwapiPerson swapiPerson : swapiPersons) {
            persons.add(convertPerson(swapiPerson));
        }

        return persons;
    }

    private List<SwapiPerson> searchPersons(String uri, List<SwapiPerson> swapiPersons) {

        var result = restTemplate
                .exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<SwapiResource<SwapiPerson>>() {
                });

        final var body = result.getBody();

        if (body == null) {
            return swapiPersons;
        }

        swapiPersons.addAll(body.getResults());
        if (body.getNext() == null) {
            return swapiPersons;
        } else {
            return searchPersons(body.getNext(), swapiPersons);
        }
    }

    /**
     * Converting SwapiPerson to Person using the MapStruct
     */
    private Person convertPerson(SwapiPerson swapiPerson) {

        final var swapiMovies = getSwapiMovies(swapiPerson.getFilms());

        return personMapper.swapiToPerson(swapiPerson, swapiMovies);
    }

    private List<SwapiMovie> getSwapiMovies(List<String> movies) {

        final List<SwapiMovie> swapiMovies = new ArrayList<>();

        for (String movie : movies) {
            final var swapiMovie = restTemplate.getForObject(movie, SwapiMovie.class);
            swapiMovies.add(swapiMovie);
        }

        return swapiMovies;
    }

    /**
     * Controller Entry Handling
     */
    public ResponseEntity<List<PersonDTO>> searchPersonResponseEntity(final String q) {
        try {
            final var personList = search(q);

            List<PersonDTO> personDTOS = new ArrayList<>();

            for (Person person : personList) {
                personDTOS.add(transformPerson(person));
            }

            logService.logRequest(true, 200, "SEARCH");
            return new ResponseEntity<>(personDTOS, HttpStatus.OK);
        } catch (Exception exception) {
            logService.logRequest(false, 500, "SEARCH");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<PersonDTO> getPersonResponseEntity(final long id) {
        try {
            final var person = get(id);

            return person.map(value -> {
                        logService.logRequest(true, 200, "GET");
                        return new ResponseEntity<>(transformPerson(value), HttpStatus.OK);
                    })
                    .orElseGet(() -> {
                        logService.logRequest(false, 404, "GET");
                        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                    });
        } catch (Exception exception) {
            logService.logRequest(false, 500, "GET");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
