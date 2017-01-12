package com.company.utils;

import com.company.exceptions.ParsingException;
import com.company.model.Color;
import com.company.model.Edge;
import com.company.model.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * A parses that converts text data to objects
 * Created by S1mpler on 1/8/2017.
 */
public class GraphDataParser {
    ///////////////////////////////////////////////////////////////////////////
    // Rools
    ///////////////////////////////////////////////////////////////////////////
    private final String COMMENT = "//";
    private final String SEPARATOR = ":";
    private final String COLOR_SEPARATOR = "-";
    private final String EDGES_SEPARATOR = ",";
    private final String FINISH_SIGN = "*";

    ///////////////////////////////////////////////////////////////////////////
    // Properties
    ///////////////////////////////////////////////////////////////////////////
    List<String> lines = new ArrayList<>();
    List<Node> nodes = new ArrayList<>();

    /**
     * Constructor
     * @param lines Lines need to be parsed
     */
    public GraphDataParser(List<String> lines) {
        this.lines = clear(lines);
    }


    /**
     * Creates objects from the plain text
     * @throws ParsingException Must be thrown if a line is not valid
     */
    public void objectifyData() throws ParsingException {
        for(String line : lines) {
            nodes.add(objectifyNode(line));
        }

        for (String line : lines) {
            if (isFinishNode(line)) continue;

            // TODO: 1/12/2017 implement better 
            List<Edge> edges = null;
            edges = parseEdges(line);
            int nodeId = Integer.parseInt(parseNodeId(line));

            Node node = getNodeById(nodeId);

            if (node == null) throw new ParsingException("Main node in this line is not initialized.");
            if (edges == null) throw new ParsingException("No edges found.");

            getNodeById(nodeId).setEdges(edges);
        }
    }

    /**
     * Returns a node by it's id
     * @param id Node's id
     * @return Return Node object
     */
    private Node getNodeById(int id) {
        for (Node node : nodes) {
            if (node.getId() == id)
                return node;
        }
        return null;
    }

    /**
     * Creates node object from the plain text
     * @param line Text line
     * @return Return node object
     */
    private Node objectifyNode(String line) {
        int id = Integer.parseInt(parseNodeId(line));
        String color = parseColor(line.split(SEPARATOR)[0]);

        return new Node(id, new Color(color));
    }

    /**
     * Parses color
     * @param line Text line
     * @return Return string color
     */
    private String parseColor(String line) {
        return line.split(COLOR_SEPARATOR)[1];
    }

    private String parseNodeId(String line) {
        return line.split(SEPARATOR)[0]
                .split(COLOR_SEPARATOR)[0];
    }

    private List<Edge> parseEdges(String line) throws ParsingException {
        List<Edge> edges = new ArrayList<>();
        String[] edgesStrings = line.split(SEPARATOR)[1].split(EDGES_SEPARATOR);

        for (String edgeString : edgesStrings) {
            String color = parseColor(edgeString);
            int connectedToNodeId = Integer.parseInt(edgeString.split(COLOR_SEPARATOR)[0]);

            Node node = null;
            for (Node n : nodes) {
                if (n.getId() == connectedToNodeId) {
                    node = n;
                    break;
                }
            }

            if (node == null) throw new ParsingException("Node which the edge must be connected to is missing.");

            edges.add(new Edge(new Color(color), node));
        }
        return edges;
    }

    private boolean isFinishNode(String line) {
        return line.split(SEPARATOR)[1].equals(FINISH_SIGN);
    }

    private List<String> clear(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line != null && !line.isEmpty() && !line.startsWith(COMMENT)) {
                result.add(line.replaceAll(" ",""));
            }
        }
        return result;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Getters
    ///////////////////////////////////////////////////////////////////////////
    public List<Node> getNodes() {
        return nodes;
    }
}
