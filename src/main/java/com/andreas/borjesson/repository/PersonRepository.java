package com.andreas.borjesson.repository;

import com.andreas.borjesson.model.Person;

import java.util.HashMap;
import java.util.Map;

public class PersonRepository {

    // "The number of stored persons is low, and it is acceptable to lose data on restarts."
    private static final Map<String, Person> database = new HashMap<>();

    /**
     * Persist a person
     *
     * @param person The person to persist
     */
    public void save(Person person) {
        database.put(person.ssn(), person);
    }

    /**
     * Fetch a person
     *
     * @param ssn The social security number of the person to fetch
     * @return The fetched person
     */
    public Person fetch(String ssn) {
        return database.get(ssn);
    }
}
