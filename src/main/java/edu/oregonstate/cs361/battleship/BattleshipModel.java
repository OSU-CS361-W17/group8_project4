package edu.oregonstate.cs361.battleship;

import java.util.ArrayList;

public class BattleshipModel {

    // User ships
    private Ship aircraftCarrier;
    private Ship battleship;
    private Ship clipper;
    private Ship dinghy;
    private Ship submarine;

    // Computer ships
    private Ship computer_aircraftCarrier;
    private Ship computer_battleship;
    private Ship computer_clipper;
    private Ship computer_dinghy;
    private Ship computer_submarine;

    // ArrayList: Player & CPU Hits/Misses
    private ArrayList<Point> playerHits;
    private ArrayList<Point> playerMisses;
    private ArrayList<Point> computerHits;
    private ArrayList<Point> computerMisses;

    // Variables for Scan Feature
    private int scanLeft;
    private ArrayList<Point> scanHits;
    private ArrayList<Point> scanMisses;
    private ArrayList<Point> scanPos;

    // ArrayList: Destroyed Player & CPU Ships
    private ArrayList<Ship> destroyedPlayerShips;
    private ArrayList<Ship> destroyedComputerShips;

    // Constructor
    public BattleshipModel() {
        // Default start and end constructs
        scanLeft = 3;
        Point start = new Point(0,0);
        Point end = new Point(0,0);
        // Creating user ships
        aircraftCarrier = new Ship("aircraftCarrier", 5, start, end);
        battleship = new Ship("battleship", 4, start, end);
        clipper = new Ship("clipper", 3, start, end);
        dinghy = new Ship("dinghy", 1, start, end);
        submarine = new Ship("submarine", 2, start, end);

        // Creating computer ships and initializing to the values from the readme.md
        computer_aircraftCarrier = new Ship("computer_aircraftCarrier", 5, new Point(2,2), new Point(2,7));
        computer_battleship = new Ship("computer_battleship", 4, new Point(2,8), new Point(6,8));
        computer_clipper = new Ship("computer_clipper", 3, new Point(4,1), new Point(4,4));
        computer_dinghy = new Ship("computer_dinghy", 1, new Point(7,3), new Point(7,3));
        computer_submarine = new Ship("computer_submarine", 2, new Point(9,6), new Point(9,8));

        // Creating ArraysLists
        playerHits = new ArrayList<Point>();
        playerMisses = new ArrayList<Point>();
        computerHits = new ArrayList<Point>();
        computerMisses = new ArrayList<Point>();
        scanHits = new ArrayList<Point>();
        scanMisses = new ArrayList<Point>();
        scanPos = new ArrayList<Point>();
        destroyedPlayerShips = new ArrayList<Ship>();
        destroyedComputerShips = new ArrayList<Ship>();
    }

    // Accessor and Mutator
    public Ship getAircraftCarrier() { return aircraftCarrier; }
    public Ship getBattleship() { return battleship; }
    public Ship getClipper() { return clipper; }
    public Ship getDinghy() { return dinghy; }
    public Ship getSubmarine() { return submarine; }
    public Ship getComputer_aircraftCarrier() { return computer_aircraftCarrier; }
    public Ship getComputer_battleship() { return computer_battleship; }
    public Ship getComputer_dinghy() { return computer_dinghy; }
    public Ship getComputer_clipper() { return computer_clipper; }
    public Ship getComputer_submarine() { return computer_submarine; }
    public ArrayList<Point> getPlayerHits() { return playerHits; }
    public ArrayList<Point> getPlayermisses() { return playerMisses;}
    public ArrayList<Point> getComputerHits() { return computerHits; }
    public ArrayList<Point> getComputermisses() { return computerMisses; }
    public ArrayList<Point> getScanHits() { return scanHits; }
    public ArrayList<Point> getScanMisses() { return scanMisses; }
    public ArrayList<Point> getScanPos() { return scanPos; }
    public ArrayList<Ship> getDestroyedPlayerShips() { return destroyedPlayerShips; }
    public ArrayList<Ship> getDestroyedComputerShips() { return destroyedComputerShips; }
    public void setAircraftCarrier (Ship aircraftCarrier) { this.aircraftCarrier = aircraftCarrier; }
    public void setBattleship(Ship battleship) {
        this.battleship = battleship;
    }
    public void setClipper(Ship clipper) {
        this.clipper = clipper;
    }
    public void setDinghy(Ship dinghy) { this.dinghy = dinghy; }
    public void setSubmarine(Ship submarine) {
        this.submarine = submarine;
    }
    public void setComputer_aircraftCarrier(Ship computer_aircraftCarrier) { this.computer_aircraftCarrier = computer_aircraftCarrier; }
    public void setComputer_battleship(Ship computer_battleship) {
        this.computer_battleship = computer_battleship;
    }
    public void setComputer_clipper(Ship computer_clipper) {
        this.computer_clipper = computer_clipper;
    }
    public void setComputer_dinghy(Ship computer_dinghy) {
        this.computer_dinghy = computer_dinghy;
    }
    public void setComputer_submarine(Ship computer_submarine) {
        this.computer_submarine = computer_submarine;
    }
    public void addPlayerHits(Point hit) { playerHits.add(hit); }
    public void addPlayerMisses(Point miss) {
        playerMisses.add(miss);
    }
    public void addComputerHits(Point hit) {
        computerHits.add(hit);
    }
    public void addComputerMisses(Point miss) {
        computerMisses.add(miss);
    }
    public void addScanHits(Point hit) {
        scanHits.add(hit);
    }
    public void addScanMisses(Point miss) {
        scanMisses.add(miss);
    }
    public void addScanPos(Point pos) {
        scanPos.add(pos);
    }
    public void addDestroyedPlayerShip(Ship deadShip) { destroyedPlayerShips.add(deadShip); }
    public void addDestroyedComputerShip(Ship deadShip) { destroyedComputerShips.add(deadShip); }

    // This function see if there are any scans available. If so, decrease the count by one and return true, else return false.
    public Boolean scansAvailable() {
        if(scanLeft != 0){
            scanLeft--;
            return true;
        }
        return false;
    }
}
