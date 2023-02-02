package org.acme.person;

import org.acme.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PersonService {

    @Inject
    PersonRepository personRepository;

    public Person getById(Long id) {
        return personRepository.findById(id);
    }

    public List<Person> getAll() {
        return personRepository.listAll();
    }

    @Transactional
    public Long create(Person person) {
        personRepository.persist(person);

        return person.getId();
    }
}
