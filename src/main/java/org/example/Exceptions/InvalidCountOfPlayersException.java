package org.example.Exceptions;

public class InvalidCountOfPlayersException extends RuntimeException{
    public InvalidCountOfPlayersException(String message) {
        super(message);
    }
}
