package com.company.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by S1mpler on 1/6/2017.
 */
public class Graph {
    ///////////////////////////////////////////////////////////////////////////
    // Properties
    ///////////////////////////////////////////////////////////////////////////
    private List<Node> nodes;

    /**
     * Constructor
     * @param nodes List of the nodes
     */
    public Graph(List<Node> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        String result = "graph {";
        for (Node node : nodes) {
            result += "\n\t" + node.toString();
        }
        result += "\n}";
        return result;
    }

    /**
     * Search a node by id
     * @param id Id of the node
     * @return Node object if it was found otherwise null
     */
    public Node getNodeById(int id) {
        for (Node node : nodes) {
            if (node.getId() == id)
                return node;
        }
        return null;
    }
}
