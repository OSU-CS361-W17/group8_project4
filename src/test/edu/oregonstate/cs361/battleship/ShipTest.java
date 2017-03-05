package edu.oregonstate.cs361.battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Joshua Lioy on 2/3/2017.
 */
class ShipTest {
    @Test
    public void testShip() {
        Point p = new Point(0, 0);
        Ship s = new Ship("cheese", 5, p, p);
        assertEquals("cheese", s.getName());
        assertEquals(5, s.getLength());
        assertEquals(p, s.getStart());
        assertEquals(p, s.getEnd());
    }
}