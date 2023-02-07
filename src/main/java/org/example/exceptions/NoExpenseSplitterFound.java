package org.example.exceptions;

public class NoExpenseSplitterFound extends RuntimeException {
    public NoExpenseSplitterFound(String s, Throwable innerException) {
        super(s, innerException);
    }
}
