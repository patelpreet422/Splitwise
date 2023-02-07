package org.example.exceptions;

public class ExpenseSplitValidationException extends RuntimeException {
    public ExpenseSplitValidationException(String s, Throwable innerException) {
        super(s, innerException);
    }
}
