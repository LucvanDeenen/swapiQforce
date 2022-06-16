package nl.qnh.qforce.controller;

import nl.qnh.qforce.domain.QforcePerson;
import nl.qnh.qforce.service.QforcePersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final QforcePersonService personService;

    public PersonController(QforcePersonService qforcePersonService) {
        this.personService = qforcePersonService;
    }

    @GetMapping("")
    public List<QforcePerson> searchPerson(@RequestParam String q) { return personService.search(q); }
}
