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

        assertEquals("AircraftCarrier",b.aircraftCarrier.name);
        assertEquals(5, b.aircraftCarrier.length);
        assertEquals("Battleship",b.battleship.name);
        assertEquals(4, b.battleship.length);
        assertEquals("Cruiser",b.cruiser.name);
        assertEquals(3, b.cruiser.length);
        assertEquals("Destroyer",b.destroyer.name);
        assertEquals(2, b.destroyer.length);
        assertEquals("Submarine",b.submarine.name);
        assertEquals(2, b.submarine.length);

        assertEquals("Computer_AircraftCarrier",b.computer_aircraftCarrier.name);
        assertEquals(5, b.computer_aircraftCarrier.length);
        assertEquals("Computer_Battleship",b.computer_battleship.name);
        assertEquals(4, b.computer_battleship.length);
        assertEquals("Computer_Cruiser",b.computer_cruiser.name);
        assertEquals(3, b.computer_cruiser.length);
        assertEquals("Computer_Destroyer",b.computer_destroyer.name);
        assertEquals(2, b.computer_destroyer.length);
        assertEquals("Computer_Submarine",b.computer_submarine.name);
        assertEquals(2, b.computer_submarine.length);

    }
}