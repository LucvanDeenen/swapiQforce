package nl.qnh.qforce.api.controller;

import nl.qnh.qforce.api.out.qforce.PersonDTO;
import nl.qnh.qforce.controller.PersonController;
import nl.qnh.qforce.domain.Person;
import nl.qnh.qforce.domain.PersonImpl;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integrationtest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersonControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    private static long id = 1;

    @Test
    @Order(1)
    public void getPersonById() {

        // Given
        final var url = PersonController.url + "/" + id;

        // When
        final var res = restTemplate.getForEntity(url, PersonDTO.class);

        // Then
        assertEquals(200, res.getStatusCodeValue());

    }

    @Test
    @Order(2)
    public void getPersons() {

        // Given
        final var query = "?q=";
        final var url = PersonController.url + "/" + query + "r";

        // When
        final var res = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<PersonDTO>>(){});

        // Then
        assertEquals(200, res.getStatusCodeValue());

    }
}
