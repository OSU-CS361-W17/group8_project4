package edu.oregonstate.cs361.battleship;

/**
 * Created by Joshua Lioy on 2/2/2017.
 */
public class Ship {
    private String name;
    private int length;
    private Point start;
    private Point end;

    public Ship(String id, int size, Point s, Point e) {
        name = id;
        length = size;
        start = s;
        end = e;
    }
}
