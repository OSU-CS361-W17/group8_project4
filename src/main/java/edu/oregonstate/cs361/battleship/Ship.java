package edu.oregonstate.cs361.battleship;

/**
 * Created by Joshua Lioy on 2/2/2017.
 */
public class Ship {
    protected String name;
    protected int length;
    protected Point start;
    protected Point end;

    public Ship(String id, int size, Point s, Point e) {
        name = id;
        length = size;
        start = s;
        end = e;
    }
}
