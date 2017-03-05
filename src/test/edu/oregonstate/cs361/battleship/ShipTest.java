package edu.oregonstate.cs361.battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Joshua Lioy on 2/3/2017.
 */
class ShipTest {
    @Test
    public void testShip() {
        Point p = new Point(0,0);
        Ship s = new Ship("cheese", 5, p, p);
        assertEquals("cheese", s.name);
        assertEquals(5, s.length);
        assertEquals(p,s.start);
        assertEquals(p, s.end);
    }
}