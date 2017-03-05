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

/**
 * Created by Chase McWhirt 3/4/2017.
 */

class CivilianShipTest {
    @Test
    public void testCivShip() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 2);
        Ship s = new Ship("civShip", 3, p1, p2);
        assertEquals("civShip", s.name);
        assertEquals(3, s.length);
        assertEquals(p1, s.start);
        assertEquals(p2, s.end);
        /*
        //Fire f = new Fire(0, 0);  //Not sure how to do this call.
        s.setHit(1);
        if (s.getHit() == 1) { s.destroy(); }
        assertEquals(1, s.hit);
        assertEquals(0, s.health);
         */
    }

}