package com.company.model;

/**
 * Representation of an edge. Edge is a part of graph.
 * It points to the other nodes.
 * Created by S1mpler on 1/6/2017.
 */
public class Edge {
    ///////////////////////////////////////////////////////////////////////////
    // Properties
    ///////////////////////////////////////////////////////////////////////////
    private Color color;
    private Node pointedToNode;

    /**
     * Constructor
     * @param color Edge's color
     * @param pointedToNode A node which the edge has to point to
     */
    public Edge(Color color, Node pointedToNode) {
        this.color = color;
        this.pointedToNode = pointedToNode;
    }


    @Override
    public String toString() {
        String result = "edge";
        result += "{to: node " + this.pointedToNode.getId();
        result += " | ";
        result += "color:" + this.color + "}";
        return result;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Getters
    ///////////////////////////////////////////////////////////////////////////
    public Color getColor() {
        return color;
    }

    public Node getPointedToNode() {
        return pointedToNode;
    }
}
