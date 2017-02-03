package edu.oregonstate.cs361.battleship;

/**
 * Created by garcibru on 2/02/17.
 */
public class UserFire {

    private int userInputRow;
    private int userInputCol;
    private boolean hit;
    private BattleshipModel new_game; // temp model.

    // e.g.
    // Set the inputs.
    // userInputRow = 2;
    // userInputCol = 3;

    public boolean wasTheShipHit() {
        /*
        // Check for computer_destroyer.
        int startRow = computer_destroyer.getStart().getCross();
        int startCol = computer_destroyer.getStart().getDown();
        int endRow = computer_destroyer.getEnd().getCross();
        int endCol = computer_destroyer.getEnd().getDown();
        hit = false;
        if(startRow == endRow) {
            if(userInputRow != startRow) hit = false;
            if(userInputCol >= startCol && userInputCol <= endCol) hit = true;
            else hit = false;
        }else{
            if(userInputCol != startCol) hit = false;
            if(userInputRol >= startRow && userInputRow <= endRow) hit = true;
            else hit = false;
        }
        if (hit == true) {
            System.out.printf("Target was hit.\n");
            for(int i= 0; i < 100; i++) {
                if(new_game.computerHits[i].getAcross && new_game.computerHits[i].getDown == 0)
            }
            new_game.computerHits[0].setAcross(userInputRow);
            new_game.computerHits[0].setDown(userInputCol);
            return true;
        }
        // Check for computer_aircraftCarrier
        startRow = computer_aircraftCarrier.getStart().getCross();
        startCol = computer_aircraftCarrier.getStart().getDown();
        endRow = computer_aircraftCarrier.getEnd().getCross();
        endCol = computer_aircraftCarrier.getEnd().getDown();
        hit = false;
        if(startRow == endRow) {
            if(userInputRow != startRow) hit = false;
            if(userInputCol >= startCol && userInputCol <= endCol) hit = true;
            else hit = false;
        }else{
            if(userInputCol != startCol) hit = false;
            if(userInputRol >= startRow && userInputRow <= endRow) hit = true;
            else hit = false;
        }
        if (hit == true) {
            System.out.printf("Target was hit.\n");
            new_game.computerHits[0].setAcross(userInputRow);
            new_game.computerHits[0].setAcross(userInputCol);
            return true;
        }
        // Check for computer_battleship
        startRow = computer_battleship.getStart().getCross();
        startCol = computer_battleship.getStart().getDown();
        endRow = computer_battleship.getEnd().getCross();
        endCol = computer_battleship.getEnd().getDown();
        hit = false;
        if(startRow == endRow) {
            if(userInputRow != startRow) hit = false;
            if(userInputCol >= startCol && userInputCol <= endCol) hit = true;
            else hit = false;
        }else{
            if(userInputCol != startCol) hit = false;
            if(userInputRol >= startRow && userInputRow <= endRow) hit = true;
            else hit = false;
        }
        if (hit == true) {
            System.out.printf("Target was hit.\n");
            new_game.computerHits[0].setAcross(userInputRow);
            new_game.computerHits[0].setAcross(userInputCol);
            return true;
        }
        // Check for computer_cruiser
        startRow = computer_cruiser.getStart().getCross();
        startCol = computer_cruiser.getStart().getDown();
        endRow = computer_cruiser.getEnd().getCross();
        endCol = computer_cruiser.getEnd().getDown();
        hit = false;
        if(startRow == endRow) {
            if(userInputRow != startRow) hit = false;
            if(userInputCol >= startCol && userInputCol <= endCol) hit = true;
            else hit = false;
        }else{
            if(userInputCol != startCol) hit = false;
            if(userInputRol >= startRow && userInputRow <= endRow) hit = true;
            else hit = false;
        }
        if (hit == true) {
            System.out.printf("Target was hit.\n");
            new_game.computerHits[0].setAcross(userInputRow);
            new_game.computerHits[0].setAcross(userInputCol);
            return true;
        }
        // Check for computer_submarine
        startRow = computer_submarine.getStart().getCross();
        startCol = computer_submarine.getStart().getDown();
        endRow = computer_submarine.getEnd().getCross();
        endCol = computer_submarine.getEnd().getDown();
        hit = false;
        if(startRow == endRow) {
            if(userInputRow != startRow) hit = false;
            if(userInputCol >= startCol && userInputCol <= endCol) hit = true;
            else hit = false;
        }else{
            if(userInputCol != startCol) hit = false;
            if(userInputRol >= startRow && userInputRow <= endRow) hit = true;
            else hit = false;
        }
        // END
        if (hit == true) {
            System.out.printf("Target was hit.\n");
            new_game.computerHits[0].setAcross(userInputRow);
            new_game.computerHits[0].setAcross(userInputCol);
            return true;
        } else {
            System.out.printf("Target was not hit.\n");
            return false;
        }
         */


    }
}