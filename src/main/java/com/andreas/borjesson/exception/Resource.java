package com.andreas.borjesson.exception;

/**
 * Used together with {@link ResourceNotFoundException}
 */
public enum Resource {
    PERSON("ssn"),
    CHILDREN("parent's ssn");

    final String idProperty;

    Resource(String idProperty) {
        this.idProperty = idProperty;
    }
}
