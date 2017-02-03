package edu.oregonstate.cs361.battleship;

/**
 * Created by garcibru on 2/02/17.
 */
public class UserFire {

    private int userInputRow;
    private int userInputCol;

    private boolean hit;

    // e.g.
    // Set the inputs.
    // userInputRow = 2;
    // userInputCol = 3;

    public boolean wasTheShipHit() {

        // int startRow = computer_destroyer.getStart().getCross();
        // int startCol = computer_destroyer.getStart().getDown();
        // int endRow = computer_destroyer.getEnd().getCross();
        // int endCol = computer_destroyer.getEnd().getDown();


        /*

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

         */

        if (hit == true) {
            System.out.printf("Target was hit.\n");
            return true;
        } else {
            System.out.printf("Target was not hit.\n");
            return false;
        }
    }


}
