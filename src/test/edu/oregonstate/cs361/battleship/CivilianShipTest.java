package edu.oregonstate.cs361.battleship;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

/**
 * Created by Chase McWhirt 3/4/2017.
 */

class CivilianShipTest {
    @Test
    public void testCivShip() {
        //Place civilian ship.
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 2);
        Point mid = new Point(0, 1);
        ArrayList<Point> hits = new ArrayList<Point>();
        CivilianShip s = new CivilianShip("civShip", 3, p1, p2, false);
        BattleshipModel b = new BattleshipModel();

        assertEquals("civShip", s.getName());
        assertEquals(3, s.getLength());
        assertEquals(p1, s.getStart());
        assertEquals(p2, s.getEnd());
        assertEquals(false, s.getHit());

        //DestroyCivilianShip
        s.setHit(true);
        s.destroy(b);
        hits = b.getPlayerHits();

        assertEquals(true, s.getHit());
        assertEquals(p1, hits.get(0));
        assertEquals(mid, hits.get(1));
        assertEquals(p2, hits.get(2));
    }
}