package joe;

import was.GameLocation;

public class Node {

    //hValue = heeuristic between end and myLocation
    //gValue = heuristic between start and myLocation
    //fValue = hValue + gValue

    public int hValue, gValue, fValue, x, y;
    public Node parent;
    GameLocation myLocation, start, end;

    public Node(GameLocation start, GameLocation end, GameLocation myLocation) {
        this.myLocation = myLocation;
        this.start = start;
        this.end = end;

        this.hValue = getValue(end, myLocation);
        this.gValue = getValue(start, myLocation);
        this.fValue = gValue + hValue;

    }

    //Can be used to update heuristics 
    void updateValues(GameLocation endPoint, GameLocation startPoint, GameLocation myLocation) {
        int dxh = Math.abs(myLocation.x - endPoint.x);
        int dyh = Math.abs(myLocation.y - endPoint.y);
        int dxg = Math.abs(startPoint.x - myLocation.x);
        int dyg = Math.abs(startPoint.y - myLocation.y);
        this.hValue = 10 * (dxh + dyh) + (14 - (2 * 10)) * Math.min(dxh, dyh);
        this.gValue = 10 * (dxg + dyg) + (14 - (2 * 10)) * Math.min(dxg, dyg);
        this.fValue = gValue + hValue;
    }

    //Calculates heuristics
    //Can be used to set initially and update later on
    int getValue(GameLocation endPoint, GameLocation myLocation) {
        int dx = Math.abs(myLocation.x - endPoint.x);
        int dy = Math.abs(myLocation.y - endPoint.y);
        int h = 10 * (dx + dy) + (14 - (2 * 10)) * Math.min(dx, dy);
        return h;
    }

    //Updates parent
    void updateParent(Node node) {
        this.parent = node;
    }

    //Used to create path; checks for parent
    boolean hasParent() {
        return this.parent != null;
    }

    //Gets node location
    public GameLocation getNodeLocation() {
        return myLocation;
    }

    @Override
    public String toString() {
        return "Node: GameLocation = " + myLocation + ", hValue =  " + hValue;
    }

}
