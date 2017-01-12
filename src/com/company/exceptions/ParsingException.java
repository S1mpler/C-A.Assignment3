package com.company.exceptions;

/**
 * Must be thrown if source.txt file has errors
 * Created by S1mpler on 1/11/2017.
 */
public class ParsingException extends Exception {
    public ParsingException(String message) {
        super(message);
    }
}
