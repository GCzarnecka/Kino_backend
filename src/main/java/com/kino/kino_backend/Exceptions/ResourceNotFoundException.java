/**

 Custom exception class for representing a resource not found error.
 */
package com.kino.kino_backend.Exceptions;

public class ResourceNotFoundException extends RuntimeException {


    /**
     * Constructs a new ResourceNotFoundException with the specified error message.
     *
     * @param message the error message
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new ResourceNotFoundException with the specified error message and cause.
     *
     * @param message the error message
     * @param cause   the cause of the exception
     */
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
