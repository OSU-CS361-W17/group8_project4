package edu.oregonstate.cs361.battleship;

/**
 * Created by Joshua Lioy on 3/4/2017.
 */
public class Ship {
    private String name;
    private int length;
    private Point start;
    private Point end;

    // Constructor
    public Ship(String name, int length, Point start, Point end) {
        this.name = name;
        this.length = length;
        this.start = start;
        this.end = end;
    }

    // Accessor and Mutator
    public String getName() { return name; }
    public int getLength() { return length; }
    public Point getStart() { return start; }
    public Point getEnd() { return end; }
    public void setName(String name) {
        this.name = name;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public void setStart(Point start) {
        this.start = start;
    }
    public void setEnd(Point end) {
        this.end = end;
    }
}
