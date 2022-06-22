package nl.qnh.qforce.controller;

import nl.qnh.qforce.api.out.qforce.PersonDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PersonController {
    ResponseEntity<List<PersonDTO>> searchPerson(@RequestParam String q);

    ResponseEntity<PersonDTO> getPerson(@PathVariable long id);
}
