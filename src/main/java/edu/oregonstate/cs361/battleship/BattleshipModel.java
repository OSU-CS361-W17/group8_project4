package edu.oregonstate.cs361.battleship;

import java.util.ArrayList;

/**
 * Created by michaelhilton on 1/26/17.
 */
public class BattleshipModel {
    //User ships
    private Ship aircraftCarrier;
    private Ship battleship;
    private Ship cruiser;
    private Ship destroyer;
    private Ship submarine;
    //Computer ships
    private Ship computer_aircraftCarrier;
    private Ship computer_battleship;
    private Ship computer_destroyer;
    private Ship computer_cruiser;
    private Ship computer_submarine;
  
    public ArrayList<Point> playerHits;
    public ArrayList<Point> playerMisses;
    public ArrayList<Point> computerHits;
    public ArrayList<Point> computerMisses;

    public BattleshipModel() {
    //Default start and end constructs
        Point us = new Point(0,0);
        Point ue = new Point(0,0);
        //Creating user ships
        aircraftCarrier = new Ship("AircraftCarrier", 5, us, ue);
        battleship = new Ship("Battleship", 4, us, ue);
        cruiser = new Ship("Cruiser", 3, us, ue);
        destroyer = new Ship("Destroyer", 2, us, ue);
        submarine = new Ship("Submarine", 2, us , ue);
        //Creating computer ships and initializing to the values from the readme.md
        computer_aircraftCarrier = new Ship("Computer_AircraftCarrier", 5, new Point(2,2), new Point(2,7));
        computer_battleship = new Ship("Computer_Battleship", 4, new Point(2,8), new Point(6,8));
        computer_cruiser = new Ship("Computer_Cruiser", 3, new Point(4,1), new Point(4,4));
        computer_destroyer = new Ship("Computer_Destroyer", 2, new Point(7,3), new Point(7,5));
        computer_submarine = new Ship("Computer_Submarine", 2, new Point(9,6), new Point(9,8));

        playerHits = new ArrayList<Point>();
        playerMisses = new ArrayList<Point>();
        computerHits = new ArrayList<Point>();
        computerMisses = new ArrayList<Point>();
    }
}
