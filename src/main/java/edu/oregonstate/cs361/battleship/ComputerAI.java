package edu.oregonstate.cs361.battleship;

/**
 * Created by jerry on 2/7/2017.
 */
public class ComputerAI {

    // Number of rows and columns on board. Cpu fire row and column.
    private int numRow;
    private int numCol;
    private int cpuFireRow;
    private int cpuFireCol;
    private Point cpuTargetFired;

    // Constructor
    public ComputerAI() {
        // Can Be Modified
        numRow = 10;
        numCol = 10;
        cpuFireRow = 1;
        cpuFireCol = 1;
        cpuTargetFired = new Point(cpuFireRow, cpuFireCol);
    }

    // This function is where all the AI logic is at
    public Point targetDeterminator() {

        /*
        Currently this AI will loop from left-top to every other space.
         */

        // If statement for starting state at Point (1,1)
        if (cpuFireRow == 1 && cpuFireCol == 1) {
            cpuFireCol += 2;
            return cpuTargetFired;
        }

        cpuTargetFired.setRow(cpuFireRow);
        cpuTargetFired.setCol(cpuFireCol);
        cpuFireCol += 2;
        if (cpuFireCol > numCol) {
            cpuFireRow += 1;
            cpuFireCol -= numCol;
            if (numCol % 2 == 0) {
                if (cpuFireRow % 2 == 0){
                    cpuFireCol += 1;
                }
                else {
                    cpuFireCol -= 1;
                }
            }
        }
        if (cpuFireRow > numRow) {
            cpuFireRow -= numRow;
        }
        return cpuTargetFired;
    }

    // When fire function is called, the AI targetDeterminator will be called
    public Point fire() {
        cpuTargetFired = targetDeterminator();
        return cpuTargetFired;
    }


    /*
    * computer begins with random choosing location to fire at on the players's board.
    * if the computer hits a ship w/ its fire, then, it will try to sink the ship.
    * the computer must adhere to the player rules of battleship. the computer cannot "cheat"
    * by seeing the location of the player's bound or ship. These are the requirements of project 4.
    * */
    /*public boolean levelOfDifficulty(boolean difficulty_hard) {

        if(difficulty_hard) {


            if() {
                // then, it will try to sink the ship.
            }

            return true;
        } else if (!difficulty_hard) {
            // The user is playing the game on easy mode.
            return false;
        }
    };*/
}
