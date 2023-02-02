package org.acme.person;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.acme.model.Person;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;

import static io.restassured.RestAssured.when;
import static org.junit.jupiter.api.Assertions.assertEquals;


@QuarkusTest
class PersonServiceTest {

    @Inject
    PersonService personService;

    @InjectMock
    PersonRepository personRepository;
    @Test
    public void shouldReturnPersonById() {
        var expectedPerson = new Person();
        expectedPerson.setId(10L);
        expectedPerson.setName("Milad");

        Mockito.when(personRepository.findById(expectedPerson.getId())).thenReturn(expectedPerson);
        Person actualPerson = personService.getById(10L);

        assertEquals(expectedPerson.getId(), actualPerson.getId());
        assertEquals(expectedPerson.getName(), actualPerson.getName());
    }

}