package org.acme.person;

import org.acme.model.Person;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/person")
public class PersonResource {

    @Inject
    PersonService personService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getById(Long id) {
        return personService.getById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllBooks() {
        return personService.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPerson(Person person) {
        personService.create(person);
        return Response.created(URI.create("http://localhost:8080/person/" + person.getId())).build();
    }
}
