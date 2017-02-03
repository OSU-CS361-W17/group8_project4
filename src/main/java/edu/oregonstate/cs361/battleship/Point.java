package edu.oregonstate.cs361.battleship;

/**
 * Created by Joshua Lioy on 2/2/2017.
 */
public class Point {
    private int Down;
    private int Across;

    public Point(int d, int a) {
        Down = d;
        Across = a;
    }

    public void setDown(int val) {
        Down = val;
    }

    public void setAcross(int val) {
        Across = val;
    }

    public int getDown() { return Down; };

    public int getAcross() { return Across; };
}
