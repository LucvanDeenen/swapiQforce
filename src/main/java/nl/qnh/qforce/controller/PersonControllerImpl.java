package nl.qnh.qforce.controller;

import nl.qnh.qforce.api.out.qforce.PersonDTO;
import nl.qnh.qforce.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonControllerImpl implements PersonController {

    @Autowired
    PersonServiceImpl personService;

    @Override
    @GetMapping
    public ResponseEntity<List<PersonDTO>> searchPerson(@RequestParam String q) {
        return personService.searchPersonResponseEntity(q);
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<PersonDTO> getPerson(@PathVariable final long id) {
        return personService.getPersonResponseEntity(id);
    }
}
