package com.andreas.borjesson.exception;

/**
 * Throw this when a person wasn't found in the database.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Resource resource, String value) {
        super(String.format(
                "%s identified by %s %s not found",
                resource.name(),
                resource.idProperty,
                value)
        );
    }
}
