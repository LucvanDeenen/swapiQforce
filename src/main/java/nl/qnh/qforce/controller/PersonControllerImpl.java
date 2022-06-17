package nl.qnh.qforce.controller;

import nl.qnh.qforce.api.out.qforce.QforcePerson;
import nl.qnh.qforce.domain.Person;
import nl.qnh.qforce.service.PersonServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonControllerImpl implements PersonController {
    private final PersonServiceImpl personService;

    public PersonControllerImpl(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @Override
    @GetMapping("")
    public List<QforcePerson> searchPerson(@RequestParam String q) {

        final var personList = personService.search(q);

        List<QforcePerson> qforcePersons = new ArrayList<>();

        for (Person person : personList) {
            qforcePersons.add(personService.transformPerson(person));
        }

        return qforcePersons;
    }

    @Override
    @GetMapping("/{id}")
    public Optional<QforcePerson> getPerson(@PathVariable final long id) {
        try {
            final var person = personService.get(id);
            return Optional.of(personService.transformPerson(person.get()));
        } catch (Exception exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND
            );
        }
    }
}
