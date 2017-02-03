package edu.oregonstate.cs361.battleship;

/**
 * Created by michaelhilton on 1/26/17.
 */
public class BattleshipModel {
    private int[] ship;
    private String ship_type;

    public BattleshipModel (int size) {
        ship = new int[size];
    }

    public void setHit() {
        for (int i = 0; i < ship.length; i++) {
            if (ship[i] == 0) {
                ship[i] = 1;
                break;
            }
        }
    }

    public boolean isDestroyed() {
        boolean destroyed = true;

        for (int i = 0; i < ship.length && destroyed; i++) {
            destroyed = ship[i] != 0;
        }
        return destroyed;
    }

    public int getSize() {
        return ship.length;
    }
}
