package com.company.model;

import com.company.exceptions.MoveToNodeException;

/**
 * Representation of the bound. Pawn is an object that moves through the graph
 * Created by S1mpler on 1/6/2017.
 */
public class Pawn {
    ///////////////////////////////////////////////////////////////////////////
    // Properties
    ///////////////////////////////////////////////////////////////////////////
    private int id;
    private Node position;

    /**
     * Constructor
     * @param id Id of the bound
     * @param position A node that the bound has to start from
     */
    public Pawn(int id, Node position) {
        this.id = id;
        this.position = position;
    }

    /**
     * Try to make a move to the other node through the edge
     * @param color Color of the edge the pawn has to go through
     */
    public void move(Color color) {
        for (Edge edge : this.position.getEdges()) {
            if (edge.getColor().getColorType() == color.getColorType()) {
                this.position = edge.getPointedToNode();
                return;
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // Getters
    ///////////////////////////////////////////////////////////////////////////
    public int getId() {
        return id;
    }

    public Node getPosition() {
        return position;
    }
}
