package nl.qnh.qforce.controller;

import nl.qnh.qforce.domain.Person;
import nl.qnh.qforce.service.PersonServiceImpl;
import org.springframework.web.bind.annotation.*;

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
    public List<Person> searchPerson(@RequestParam String q) { return personService.search(q); }

    @Override
    @GetMapping("/{id}")
    public Optional<Person> getPerson(@PathVariable final long id) {
        return personService.get(id);
    }
}
