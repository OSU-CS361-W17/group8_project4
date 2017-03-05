package edu.oregonstate.cs361.battleship;

/**
 * Created by Joshua Lioy on 3/4/2017.
 */
public class CivilianShip extends Ship {
    boolean isHit;

    public CivilianShip(String name, int length, Point start, Point end, boolean hit) {
        super(name, length, start, end);
        isHit = hit;
    }

}
