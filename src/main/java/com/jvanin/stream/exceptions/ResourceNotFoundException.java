package com.jvanin.stream.exceptions;


public class ResourceNotFoundException extends RuntimeException {

    public static final String RESOURCE_NOT_FOUND_MESSAGE = "%s with id %s not found";
    public static final String NO_RESOURCES_FOUND = "No resources of type %s was found";

    public ResourceNotFoundException(String resource, Long id) {
        super(String.format(RESOURCE_NOT_FOUND_MESSAGE, resource, id));
    }

    public ResourceNotFoundException(String resource){
        super(String.format(NO_RESOURCES_FOUND, resource));
    }

}
