package edu.oregonstate.cs361.battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Joshua Lioy on 2/3/2017.
 */
class ShipTest {
    @Test
    public void testShip() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        Ship s = new Ship("cheese", 5, p1, p1);

        s.setName("bobby");
        assertEquals("bobby", s.getName());
        s.setLength(4);
        assertEquals(4, s.getLength());
        s.setStart(p2);
        assertEquals(p2, s.getStart());
        s.setEnd(p2);
        assertEquals(p2, s.getEnd());
        s.setStealthMode(true);
        assertEquals(true, s.getStealthMode());
    }
}