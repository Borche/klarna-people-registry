package com.andreas.borjesson;

import com.andreas.borjesson.model.Child;
import com.andreas.borjesson.model.Person;
import com.andreas.borjesson.service.PersonService;

import java.util.List;
import java.util.Map;

public class Main {
    final static PersonService personService = new PersonService();

    /*
     * Proof of concept..
     */
    public static void main(String[] args) {
        String SSN = "8904255559";

        personService.save(createTestPerson(SSN, true));

        Person fetchedPerson = personService.fetch(SSN);
        System.out.println("1. ----");
        System.out.println(fetchedPerson);

        Child oldestChild = personService.getOldestChild(fetchedPerson);
        System.out.println("2. ----");
        System.out.println(
                Map.of("ssn", fetchedPerson.ssn(), "nameOfOldestChild", oldestChild.name())
        );

        try {
            // Doesnt exist - throws exception
            personService.fetch("8903151234");
        } catch (Exception e) {
            System.out.println("3. ----");
            System.out.println(e);
        }

        try {
            // Has no children - throws exception
            personService.getOldestChild(createTestPerson(SSN, false));
        } catch (Exception e) {
            System.out.println("4. ----");
            System.out.println(e);
        }
    }

    private static Person createTestPerson(String ssn, boolean createChildren) {
        Person p = new Person(ssn, "Andreas Börjesson", "Daenerys Targaryen", null);

        if (createChildren) {
            Child c1 = new Child("Daniel", 5);
            Child c2 = new Child("Jessica", 13);
            Child c3 = new Child("Britney", 16);
            Child c4 = new Child("Gunnar", 16);
            Child c5 = new Child("Adam", 3);

            p.children().addAll(List.of(c1, c2, c3, c4, c5));
        }

        return p;
    }
}