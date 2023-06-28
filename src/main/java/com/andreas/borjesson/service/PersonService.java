package com.andreas.borjesson.service;

import com.andreas.borjesson.exception.Resource;
import com.andreas.borjesson.exception.ResourceNotFoundException;
import com.andreas.borjesson.model.Child;
import com.andreas.borjesson.model.Person;
import com.andreas.borjesson.repository.PersonRepository;

import java.util.Comparator;

/**
 * Service for managing persons
 */
public class PersonService {

    final PersonRepository personRepository = new PersonRepository();

    public void save(Person person) {
        personRepository.save(person);
    }

    public Person fetch(String ssn) {
        Person person = personRepository.fetch(ssn);

        if (person == null) {
            // Let presentation layer handle
            throw new ResourceNotFoundException(Resource.PERSON, ssn);
        }

        return person;
    }

    public Child getOldestChild(Person person) {
        return person.children().stream()
                .max(Comparator.comparingInt(Child::age))
                .orElseThrow(
                        // Let presentation layer handle
                        () -> new ResourceNotFoundException(Resource.CHILDREN, person.ssn())
                );
    }
}

