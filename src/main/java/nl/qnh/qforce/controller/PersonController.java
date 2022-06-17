package nl.qnh.qforce.controller;

import nl.qnh.qforce.api.out.qforce.QforcePerson;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface PersonController {
    List<QforcePerson> searchPerson(@RequestParam String q);

    Optional<QforcePerson> getPerson(@PathVariable long id);
}
