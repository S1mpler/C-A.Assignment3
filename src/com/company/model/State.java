package com.company.model;

/**
 * Represents a state of the graph.
 * Created by S1mpler on 1/12/2017.
 */
public class State {
    ///////////////////////////////////////////////////////////////////////////
    // Properties
    ///////////////////////////////////////////////////////////////////////////
    private Node position1;
    private Node position2;

    /**
     * Constructor
     * @param position1 Position of pawn 1
     * @param position2 Position of pawn 2
     */
    public State(Node position1, Node position2) {
        this.position1 = position1;
        this.position2 = position2;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Getters
    ///////////////////////////////////////////////////////////////////////////
    public Node getPosition1() {
        return position1;
    }

    public Node getPosition2() {
        return position2;
    }
}

