package com.example.projectfx.exceptions;

/**
 * Custom exception class for the ecosystem simulation.
 */
public class EcosystemException extends Exception {

    /**
     * Constructs a new EcosystemException with the specified detail message.
     *
     * @param message The detail message.
     */
    public EcosystemException(String message) {
        super(message);
    }

    /**
     * Constructs a new EcosystemException with the specified detail message and cause.
     *
     * @param message The detail message.
     * @param cause   The cause of the exception.
     */
    public EcosystemException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new EcosystemException with the specified cause.
     *
     * @param cause The cause of the exception.
     */
    public EcosystemException(Throwable cause) {
        super(cause);
    }
}