package nl.qnh.qforce.controller;

import nl.qnh.qforce.domain.Person;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface PersonController {
    List<Person> searchPerson(@RequestParam String q);

    Optional<Person> getPerson(@PathVariable long id);
}
