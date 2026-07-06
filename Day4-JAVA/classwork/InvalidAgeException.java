package com.coforge.day4.exception;

public class InvalidAgeException extends Exception {

    public InvalidAgeException() {
        super("Invalid Age! You are not eligible to vote.");
    }

}