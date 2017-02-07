package edu.oregonstate.cs361.battleship;

/**
 * Created by Joshua Lioy on 2/2/2017.
 */
public class Point {
    private int row; // row
    private int col; // column

    // Constructor
    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // Accessor and Mutator
    public int getRow() { return this.row; }
    public int getCol() { return this.col; }

    public void setRow(int row) {
        this.row = row;
    }
    public void setCol(int col) {
        this.col = col;
    }
}
