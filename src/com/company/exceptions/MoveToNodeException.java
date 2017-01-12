package com.company.exceptions;

/**
 * Must be thrown if pawn is not allowed to move to the node
 * Created by S1mpler on 1/6/2017.
 */
public class MoveToNodeException extends Exception {
    public MoveToNodeException(String message) {
        super(message);
    }
}
