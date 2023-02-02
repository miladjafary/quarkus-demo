package org.acme.person;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.model.Person;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    public Person findByName(String name) {
        return find("name", name).firstResult();
    }

}
