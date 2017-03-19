package edu.oregonstate.cs361.battleship;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Joshua Lioy on 2/3/2017.
 */
class BattleshipModelTest {
    @Test
    public void testBattleShipModel() {
        Point p = new Point(0,0);
        BattleshipModel b = new BattleshipModel();
        ArrayList<Point> al = new ArrayList<Point>();
        ArrayList<Ship> al2 = new ArrayList<Ship>();

        Ship aircraftCarrier = new Ship("aircraftCarrier", 5, p, p);
        Ship battleship = new Ship("battleship", 4, p, p);
        Ship clipper = new Ship("clipper", 3, p, p);
        Ship dinghy = new Ship("dinghy", 1, p, p);
        Ship submarine = new Ship("submarine", 2, p, p);

        Ship computer_aircraftCarrier = new Ship("computer_aircraftCarrier", 5, new Point(2,2), new Point(2,7));
        Ship computer_battleship = new Ship("computer_battleship", 4, new Point(2,8), new Point(6,8));
        Ship computer_clipper = new Ship("computer_clipper", 3, new Point(4,1), new Point(4,4));
        Ship computer_dinghy = new Ship("computer_dinghy", 1, new Point(7,3), new Point(7,3));
        Ship computer_submarine = new Ship("computer_submarine", 2, new Point(9,6), new Point(9,8));

        b.setAircraftCarrier(aircraftCarrier);
        assertEquals(aircraftCarrier, b.getAircraftCarrier());
        b.setBattleship(battleship);
        assertEquals(battleship, b.getBattleship());
        b.setClipper(clipper);
        assertEquals(clipper, b.getClipper());
        b.setDinghy(dinghy);
        assertEquals(dinghy, b.getDinghy());
        b.setSubmarine(submarine);
        assertEquals(submarine, b.getSubmarine());
        b.setComputer_aircraftCarrier(computer_aircraftCarrier);
        assertEquals(computer_aircraftCarrier, b.getComputer_aircraftCarrier());
        b.setComputer_battleship(computer_battleship);
        assertEquals(computer_battleship, b.getComputer_battleship());
        b.setComputer_clipper(computer_clipper);
        assertEquals(computer_clipper, b.getComputer_clipper());
        b.setComputer_dinghy(computer_dinghy);
        assertEquals(computer_dinghy, b.getComputer_dinghy());
        b.setComputer_submarine(computer_submarine);
        assertEquals(computer_submarine, b.getComputer_submarine());

        al.add(p);
        b.addPlayerHits(p);
        assertEquals(al, b.getPlayerHits());
        b.addPlayerMisses(p);
        assertEquals(al, b.getPlayerMisses());
        b.addComputerHits(p);
        assertEquals(al, b.getComputerHits());
        b.addComputerMisses(p);
        assertEquals(al, b.getComputerMisses());
        b.addScanHits(p);
        assertEquals(al, b.getScanHits());
        b.addScanMisses(p);
        assertEquals(al, b.getScanMisses());
        b.addScanPos(p);
        assertEquals(al, b.getScanPos());

        assertEquals(true, b.scansAvailable());

        al2.add(computer_aircraftCarrier);
        b.addDestroyedComputerShip(computer_aircraftCarrier);
        assertEquals(al2, b.getDestroyedComputerShips());
        al2.remove(computer_aircraftCarrier);
        al2.add(aircraftCarrier);
        b.addDestroyedPlayerShip(aircraftCarrier);
        assertEquals(al2, b.getDestroyedPlayerShips());
    }
}