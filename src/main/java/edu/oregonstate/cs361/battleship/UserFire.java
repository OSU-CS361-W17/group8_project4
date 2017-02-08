package edu.oregonstate.cs361.battleship;

/**
 * Created by garcibru on 2/02/17.
 */
public class UserFire {

    private int userInputRow;
    private int userInputCol;
    private Point userPoint;          // Stores the point of the user.
    private boolean hit;
    private BattleshipModel new_game; // temp model.

    public UserFire() {
        userInputRow = 0;
        userInputCol = 0;
        hit = false;
        userPoint = new Point();
        new_game = new BattleshipModel();
    }

    // Getting input from the user.
    public void setInput(int across, int down) {
        userInputRow = across;
        userInputCol = down;
        userPoint.setAcross(across);
        userPoint.setDown(down);
    }

    // Determines whether the ship was hit (true), or not (false).
    public boolean wasTheShipHit() {

        // Check for computer_destroyer.
        int startRow = new_game.computer_destroyer.start.getAcross();
        int startCol = new_game.computer_destroyer.start.getDown();
        int endRow = new_game.computer_destroyer.end.getAcross();
        int endCol = new_game.computer_destroyer.end.getDown();
        hit = false;

        // Check if the user input hit the target.
        if(startRow == endRow) {
            if(userInputRow != startRow) hit = false;
            if(userInputCol >= startCol && userInputCol <= endCol) hit = true;
            else hit = false;
        }else{
            if(userInputCol != startCol) hit = false;
            if(userInputRol >= startRow && userInputRow <= endRow) hit = true;
            else hit = false;
        }

        // If the computer_destroyer was hit, store it in the playerHits array.
        if (hit == true) {

            System.out.printf("Target was hit.\n");

            for(int i= 0; i < (new_game.playerHits.size() + 1); i++) {
                // Get the point from the array
                Point temp = new_game.playerHits.get(i);
                int tempRow = temp.getAcross();
                int tempCol = temp.getDown();

                // If this section of the array is empty, store point in this location.
                if(tempRow == 0 && tempCol == 0) {

                    // Enter the set points of computer destroyer into the computerHits array.
                    new_game.computerHits.add(i, userPoint);
                    return true;
                }
            }
        }

        // Check for computer_aircraftCarrier
        startRow = new_game.computer_aircraftCarrier.start.getAcross();
        startCol = new_game.computer_aircraftCarrier.start.getDown();
        endRow = new_game.computer_aircraftCarrier.end.getAcross();
        endCol = new_game.computer_aircraftCarrier.end.getDown();
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

            for(int i= 0; i < (new_game.playerHits.size() + 1); i++) {

                // Get the point from the array
                Point temp = new_game.playerHits.get(i);
                int tempRow = temp.getAcross();
                int tempCol = temp.getDown();

                // If this section of the array is empty, store point in this location.
                if(tempRow == 0 && tempCol == 0) {

                    // Enter the point of computer_destroyer into the computerHits array.
                    new_game.computerHits.add(i, userPoint);
                    return true;
                }
            }

        }

        // Check for computer_battleship
        startRow = new_game.computer_battleship.start.getAcross();
        startCol = new_game.computer_battleship.start.getDown();
        endRow = new_game.computer_battleship.end.getAcross();
        endCol = new_game.computer_battleship.end.getDown();
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
            for(int i= 0; i < (new_game.playerHits.size() + 1); i++) {

                // Get the point from the array
                Point temp = new_game.playerHits.get(i);
                int tempRow = temp.getAcross();
                int tempCol = temp.getDown();

                // If this section of the array is empty, store point in this location.
                if(tempRow == 0 && tempCol == 0) {

                    // Enter the point of computer_battleship into the computerHits array.
                    new_game.computerHits.add(i, userPoint);
                    return true;
                }
            }
        }

        // Check for computer_cruiser
        startRow = new_game.computer_cruiser.start.getAcross();
        startCol = new_game.computer_cruiser.start.getDown();
        endRow = new_game.computer_cruiser.end.getAcross();
        endCol = new_game.computer_cruiser.end.getDown();
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
            for(int i= 0; i < (new_game.playerHits.size() + 1); i++) {

                // Get the point from the array
                Point temp = new_game.playerHits.get(i);
                int tempRow = temp.getAcross();
                int tempCol = temp.getDown();

                // If this section of the array is empty, store point in this location.
                if(tempRow == 0 && tempCol == 0) {

                    // Enter the point of computer_cruiser into the computerHits array.
                    new_game.computerHits.add(i, userPoint);
                    return true;
                }
            }
        }

        // Check for computer_submarine
        startRow = new_game.computer_submarine.start.getAcross();
        startCol = new_game.computer_submarine.start.getDown();
        endRow = new_game.computer_submarine.end.getAcross();
        endCol = new_game.computer_submarine.end.getDown();
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

            for(int i= 0; i < (new_game.playerHits.size() + 1); i++) {

                // Get the point from the array
                Point temp = new_game.playerHits.get(i);
                int tempRow = temp.getAcross();
                int tempCol = temp.getDown();

                // If this section of the array is empty, store point in this location.
                if(tempRow == 0 && tempCol == 0) {

                    // Enter the point of computer_cruiser into the computerHits array.
                    new_game.computerHits.add(i, userPoint);
                    return true;
                }
            }
        } else {
            System.out.printf("Target was not hit.\n");
            for(int i= 0; i < (new_game.playerMisses.size() + 1); i++) {

                // Get the point from the array
                Point temp = new_game.playerMisses.get(i);
                int tempRow = temp.getAcross();
                int tempCol = temp.getDown();

                // If this section of the array is empty, store point in this location.
                if(tempRow == 0 && tempCol == 0) {

                    // Enter the point of computer_cruiser into the computerHits array.
                    new_game.playerMisses.add(i, userPoint);
                    return false;
                }
            }

        }

        // Must be an error.
        return false;
    }
}
