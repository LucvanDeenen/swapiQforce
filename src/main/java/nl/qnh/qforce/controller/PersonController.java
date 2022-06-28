package nl.qnh.qforce.controller;

import nl.qnh.qforce.api.out.qforce.PersonDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping(PersonController.url)
public interface PersonController {

    String url = "/api/persons";

    @GetMapping
    ResponseEntity<List<PersonDTO>> searchPerson(@RequestParam String q);

    @GetMapping("{id}")
    ResponseEntity<PersonDTO> getPerson(@PathVariable long id);
}
