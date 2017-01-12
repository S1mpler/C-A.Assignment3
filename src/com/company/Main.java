package com.company;

import com.company.exceptions.ParsingException;
import com.company.model.Graph;
import com.company.model.Node;
import com.company.model.Pawn;
import com.company.utils.FileReader;
import com.company.utils.GraphDataParser;

import java.util.List;

public class Main {

    private static final String SOURCE_FILE_NAME = "source.txt";
    private static final int PAWN_1_START_NODE_ID = 1;
    private static final int PAWN_2_START_NODE_ID = 2;

    public static void main(String[] args) {
        FileReader fReader = new FileReader(SOURCE_FILE_NAME);

        List<String> lines = fReader.getLines();

        GraphDataParser parser = new GraphDataParser(lines);

        try {
            parser.objectifyData();
        } catch (ParsingException e) {
            e.printStackTrace();
        }

        Graph graph = new Graph(parser.getNodes());
        Pawn pawn1 = new Pawn(1, graph.getNodeById(PAWN_1_START_NODE_ID));
        Pawn pawn2 = new Pawn(2, graph.getNodeById(PAWN_2_START_NODE_ID));

        System.out.println(graph);

        PathFinder pathFinder = new PathFinder(pawn1, pawn2, graph);

        pathFinder.run();

        for (Node node : pathFinder.getResult()) {
            System.out.println(node.getId());
        }
    }
}
