package com.company.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of the node. Node is a part of the graph.
 * Created by S1mpler on 1/6/2017.
 */
public class Node {
    ///////////////////////////////////////////////////////////////////////////
    // Properties
    ///////////////////////////////////////////////////////////////////////////
    private int id;
    private Color color;
    private List<Edge> edges = new ArrayList<>();

    /**
     * Constructor
     * @param id Node's id
     * @param color Color of the node
     * @param edges All edges pointed from the node
     */
    public Node(int id, Color color, List<Edge> edges) {
        this.id = id;
        this.color = color;
        this.edges = edges;
    }

    /**
     * Constructor for node without any edges
     * @param id Node's id
     * @param color Color of the node
     */
    public Node(int id, Color color) {
        this.id = id;
        this.color = color;
    }

    @Override
    public String toString() {
        String result = "node";
        result += "{id:" + this.id;
        result += " | ";
        result += "color:" + this.color;
        result += " | ";
        result += "{";
        for (Edge edge : this.edges) {
            result += "\n";
            result += "\t\t" + edge.toString();
            if (edges.indexOf(edge) != edges.size() - 1) {
                result += " | ";
            } else {
                result += "\n";
            }
        }
        result += "\t}";
        result += "}";
        return result;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Getters
    ///////////////////////////////////////////////////////////////////////////
    public int getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Setters
    ///////////////////////////////////////////////////////////////////////////
    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }
}
