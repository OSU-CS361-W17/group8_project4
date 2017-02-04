package edu.oregonstate.cs361.battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Joshua Lioy on 2/3/2017.
 */
class PointTest {
    @Test
    public void testSetDown() {
        Point a = new Point(0,0);
        a.setDown(2);
        assertEquals(2, a.getDown());
    }

    @Test
    public void setAcross() {
        Point a = new Point(0,0);
        a.setAcross(2);
        assertEquals(2, a.getAcross());
    }

    @Test
    public void getDown() {
        Point a = new Point(0,0);
        assertEquals(0, a.getDown());
    }

    @Test
    public void getAcross() {
        Point a = new Point(0,0);
        assertEquals(0, a.getAcross());
    }

}