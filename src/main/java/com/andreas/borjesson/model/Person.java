package com.andreas.borjesson.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @param ssn        Social security number
 * @param name       Name
 * @param nameSpouse Name of this person's spouse
 * @param children   This person's children
 */
public record Person(String ssn, String name, String nameSpouse, List<Child> children) {
    public Person {
        if (ssn == null || ssn.isBlank()) throw new IllegalArgumentException("ssn must not be blank");
        if (children == null) children = new ArrayList<>();
    }

    public Person(String ssn, String name, String nameSpouse) {
        this(ssn, name, nameSpouse, null);
    }

    public Person(String ssn, String name) {
        this(ssn, name, null);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Person other) {
            // "The POC should allow users to save and retrieve information about
            // a person using their social security number as the identifier."
            return Objects.equals(this.ssn, other.ssn);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return ssn.hashCode();
    }
}