package edu.oregonstate.cs361.battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Joshua Lioy on 2/3/2017.
 */
class BattleshipModelTest {
    @Test
    public void testBattleShipModel() {
        Point p = new Point(0,0);
        BattleshipModel b = new BattleshipModel();

        Ship s = b.getAircraftCarrier();
        assertEquals("AircraftCarrier",s.getName());
        assertEquals(5, s.getLength());
        s = b.getBattleship();
        assertEquals("Battleship", s.getName());
        assertEquals(4, s.getLength());
        s = b.getClipper();
        assertEquals("Clipper", s.getName());
        assertEquals(3, s.getLength());
        s = b.getDinghy();
        assertEquals("Dinghy", s.getName());
        assertEquals(1, s.getLength());
        s = b.getSubmarine();
        assertEquals("Submarine", s.getName());
        assertEquals(2, s.getLength());

        s = b.getComputer_aircraftCarrier();
        assertEquals("Computer_AircraftCarrier", s.getName());
        assertEquals(5, s.getLength());
        s = b.getComputer_battleship();
        assertEquals("Computer_Battleship", s.getName());
        assertEquals(4, s.getLength());
        s = b.getComputer_clipper();
        assertEquals("Computer_Clipper", s.getName());
        assertEquals(3, s.getLength());
        s = b.getComputer_dinghy();
        assertEquals("Computer_Dinghy", s.getName());
        assertEquals(1, s.getLength());
        s = b.getComputer_submarine();
        assertEquals("Computer_Submarine", s.getName());
        assertEquals(2, s.getLength());

    }
}