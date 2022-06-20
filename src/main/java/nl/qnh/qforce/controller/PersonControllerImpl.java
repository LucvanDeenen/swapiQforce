package nl.qnh.qforce.controller;

import nl.qnh.qforce.api.out.qforce.QforcePerson;
import nl.qnh.qforce.domain.Person;
import nl.qnh.qforce.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonControllerImpl implements PersonController {

    private final PersonServiceImpl personService;

    @Autowired
    public PersonControllerImpl(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<QforcePerson>> searchPerson(@RequestParam String q) {
        final var personList = personService.search(q);

        List<QforcePerson> qforcePersons = new ArrayList<>();

        for (Person person : personList) {
            qforcePersons.add(personService.transformPerson(person));
        }

        return new ResponseEntity<>(qforcePersons, HttpStatus.OK);
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<QforcePerson> getPerson(@PathVariable final long id) {
        final var person = personService.get(id);

        if (person.isPresent()) {
            return new ResponseEntity<>(personService.transformPerson(person.get()), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
