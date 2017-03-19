package edu.oregonstate.cs361.battleship;

/**
 * Created by Joshua Lioy and Chase McWhirt on 3/4/2017.
 */
public class CivilianShip extends Ship {
    private boolean isHit;

    public CivilianShip(String name, int length, Point start, Point end, boolean hit) {
        super(name, length, start, end);
        isHit = hit;
    }

    private Point initialShot = this.getStart();

    public void destroy(BattleshipModel currentModel) {
        if(this.getStart().getRow() != this.getEnd().getRow()) {
            for(int i = 0; i < this.getLength(); i++) {
                initialShot.setRow(initialShot.getRow() + i);
                currentModel.addPlayerHits(initialShot);
            }
        }

        else if(this.getStart().getCol() != this.getEnd().getCol()) {
            for(int i = 0; i < this.getLength(); i++) {
                initialShot.setCol(initialShot.getCol() + i);
                currentModel.addPlayerHits(initialShot);
            }
        }

        else {
            currentModel.addPlayerHits(initialShot);
        }
    }

    //Accessors
    public boolean getHit() { return isHit; }

    //Mutators
    public void setHit(boolean shot) { this.isHit = shot; }
}

/*
if ([A CIVILIAN SHIP WAS HIT]) {
    ship.setHit(1);
    ship.destroy([INSERT MODEL OBJECT]);
}
 */