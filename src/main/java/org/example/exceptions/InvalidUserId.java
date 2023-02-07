package org.example.exceptions;

public class InvalidUserId extends RuntimeException {
    public InvalidUserId(String s, Throwable innerException) {
        super(s, innerException);
    }
}
