package edu.oregonstate.cs361.battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Joshua Lioy on 2/3/2017.
 */
class PointTest {
    @Test
    public void testSetCol() {
        Point a = new Point(0,0);
        a.setCol(2);
        assertEquals(2, a.getCol());
    }

    @Test
    public void testSetRow() {
        Point a = new Point(0,0);
        a.setRow(2);
        assertEquals(2, a.getRow());
    }

//    @Test
//    public void getCol() {
//        Point a = new Point(0,0);
//        assertEquals(0, a.getDown());
//    }
//
//    @Test
//    public void getRow() {
//        Point a = new Point(0,0);
//        assertEquals(0, a.getAcross());
//    }

}