package com.nbs.bia.hackathon.gamification.exceptions;

public class CreateEventsException extends RuntimeException {
    private String message;

    public CreateEventsException() {}
    public CreateEventsException(String message) {
        this.message = message;
    }
}
