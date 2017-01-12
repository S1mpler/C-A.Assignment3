package com.company;

import com.company.model.*;

import java.util.*;

/**
 * Class which finds solution to the graph
 * Created by S1mpler on 1/11/2017.
 */
public class PathFinder {
    ///////////////////////////////////////////////////////////////////////////
    // Properties
    ///////////////////////////////////////////////////////////////////////////
    private Pawn pawn1;
    private Pawn pawn2;
    private Pawn currentPawn; //holds pawn 1 or pawn 2

    private Graph graph;
    private LinkedList<Node> result = new LinkedList<>();
    private Stack<State> states = new Stack<>();

    /**
     * Constructor
     * @param pawn1 First pawn
     * @param pawn2 Second pawn
     * @param graph Entire graph
     */
    public PathFinder(Pawn pawn1, Pawn pawn2, Graph graph) {
        this.pawn1 = pawn1;
        this.pawn2 = pawn2;
        this.graph = graph;
    }

    /**
     * Main method
     */
    public void run() {
        setTurnTo(randomPawn());
        dfs(currentPawn);

    }

    /**
     * Depth first search
     */
    private void dfs(Pawn pawn) {
        if (canMove(pawn)) {
            pawn.move(getAvailableColor(pawn));
            System.out.println(pawn.getPosition().getId());
            result.add(pawn.getPosition());
            if (isFinish(pawn.getPosition())) {
                return;
            } else {
                dfs(pawn);
            }
        } else {
            setTurnTo(anotherPawn());
            dfs(currentPawn);
        }
    }

    /**
     * The functions returns another pawn depending on the selected pawn
     * @return Another pawn
     */
    private Pawn anotherPawn() {
        switch (this.currentPawn.getId()) {
            case 1 :
                return pawn2;
            case 2 :
                return pawn1;
        }
        return null;
    }

    /**
     * Figures out what color is available to move through for the pawn
     * @param pawn Pawn that is desired to move
     * @return Returns a Color object
     */
    private Color getAvailableColor(Pawn pawn) {
        switch (pawn.getId()) {
            case 1:
                return pawn2.getPosition().getColor();
            case 2:
                return pawn1.getPosition().getColor();
        }
        return null;
    }

    /**
     * The functions checks if the selected pawn can move from the it's current position
     * @param pawn Pawn that wants to be checked
     * @return Returns true if the pawn can move otherwise false
     */
    private boolean canMove(Pawn pawn) {
        Color color = getAvailableColor(pawn);
        for (Edge edge : pawn.getPosition().getEdges()) {
            if (color.getColorType() == edge.getColor().getColorType()) {
                return true;
            }
        }
        return false;
    }

    /**
     * The method sets turn to the selected pawn
     * @param pawn The pawn which is needed to set turn to
     */
    private void setTurnTo(Pawn pawn) {
        this.currentPawn = pawn;
    }

    /**
     * The function checks if the position is the finish point of the graph
     * @param node Node(position) that is wanted to be checked
     * @return Returns true if the node is the finish point
     *      otherwise false
     */
    private boolean isFinish(Node node) {
        return node.getColor().getColorType() == Color.ColorType.FINISH;
    }

    /**
     * The function returns a random pawn (either pawn1 or pawn2)
     * @return Returns a random pawn
     */
    private Pawn randomPawn() {
        int r = new Random().nextInt(2) + 1; // value 1 or 2
        switch (r) {
            case 1:
                return pawn1;
            case 2:
                return pawn2;
        }
        return null;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Getters
    ///////////////////////////////////////////////////////////////////////////
    public LinkedList<Node> getResult() {
        return result;
    }
}
