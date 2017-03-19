package edu.oregonstate.cs361.battleship;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jerry on 2/7/2017.
 * Recreated by mcwhirtc on March 18th, 2017.
 */
public class ComputerAI {
    // Number of rows and columns on board. Cpu fire row and column.
    private int numRow;
    private int numCol;
    private int cpuFireRow;
    private int cpuFireCol;
    private boolean cpuHardDifficulty;
    private Point cpuTargetFired;

    // Constructor
    public ComputerAI() {
        // Can Be Modified
        numRow = 9;
        numCol = 9;
        cpuFireRow = 0;
        cpuFireCol = 0;
        cpuHardDifficulty = false;
        cpuTargetFired = new Point(cpuFireRow, cpuFireCol);
    }

    // This function is where all the AI logic is at
    public Point targetDeterminator(BattleshipModel cpuModel) {
        Random pos = new Random();
        int rawCoords;
        ArrayList<Point> injuredShips;
        ArrayList<Point> adjacentSpots;

        if(cpuHardDifficulty == true) {
            //All hits that aren't associated with destroyed ships.
            injuredShips = hitLiveShipChecker(cpuModel);

            //If we've detected a live ship, hunt it down.
            if(injuredShips.size() != 0) {
                adjacentSpots = listRelevantViableCoords(injuredShips, cpuModel);

                //An optimization could be inserted here to shoot in the path as the rest of the hits.
                cpuTargetFired.setRow(adjacentSpots.get(0).getRow());
                cpuTargetFired.setCol(adjacentSpots.get(0).getCol());
            }

            //Else search for a new target.
            else {
                do {
                    //Can be refined to shoot in every other space.
                    rawCoords = pos.nextInt(100);
                    cpuFireRow = rawCoords / 10;
                    cpuFireCol = rawCoords % 10;
                }while(fireOverlapChecker(cpuModel, cpuFireRow, cpuFireCol) == true);

                cpuTargetFired.setRow(cpuFireRow);
                cpuTargetFired.setCol(cpuFireCol);
            }
        }

        else {
            do {
                rawCoords = pos.nextInt(100);
                cpuFireRow = rawCoords / 10;
                cpuFireCol = rawCoords % 10;
            }while(fireOverlapChecker(cpuModel, cpuFireRow, cpuFireCol) == true);

            cpuTargetFired.setRow(cpuFireRow);
            cpuTargetFired.setCol(cpuFireCol);
        }

        return cpuTargetFired;
    }

    private ArrayList<Point> listRelevantViableCoords(ArrayList<Point> injuredShips, BattleshipModel cpuModel) {
        ArrayList<Point> adjCoords = new ArrayList<Point>();
        Point temp;

        for(int i = 0; i < injuredShips.size(); i++) {
            temp = injuredShips.get(i);     //Reset Temp
            temp.setCol(temp.getCol() - 1); //West
            adjCoords.add(temp);

            temp.setCol(temp.getCol() + 2); //East
            adjCoords.add(temp);

            temp = injuredShips.get(i);     //Reset Temp
            temp.setRow(temp.getRow() - 1); //North
            adjCoords.add(temp);

            temp.setRow(temp.getRow() + 2); //South
            adjCoords.add(temp);
        }

        adjCoords = cleanAdjacencyList(adjCoords, cpuModel.getComputerMisses(), injuredShips);

        //An optimization could be inserted here to shoot in the path as the rest of the hits.

        return adjCoords;
    }

    private ArrayList<Point> cleanAdjacencyList(ArrayList<Point> dirtyAdjCoords, ArrayList<Point> misses, ArrayList<Point> hits) {
        ArrayList<Point> outOfBounds = new ArrayList<Point>();
        Point northwestBound = new Point(-1, -1);
        Point southeathBound = new Point(10, 10);
        Point temp;

        outOfBounds.add(northwestBound);
        for(int i = 0; i < 11; i++) {
            temp = northwestBound;
            temp.setRow(i);
            outOfBounds.add(temp);

            temp = northwestBound;
            temp.setCol(i);
            outOfBounds.add(temp);

            temp = southeathBound;
            temp.setRow(10 - i);
            outOfBounds.add(temp);

            temp = southeathBound;
            temp.setCol(10 - i);
            outOfBounds.add(temp);
        }

        for(int i = 0; i < outOfBounds.size(); i++) {
            if(dirtyAdjCoords.contains(outOfBounds.get(i))) {
                dirtyAdjCoords.remove(dirtyAdjCoords.indexOf(outOfBounds.get(i)));
            }
        }

        for(int i = 0; i < misses.size(); i++) {
            if(dirtyAdjCoords.contains(misses.get(i))) {
                dirtyAdjCoords.remove(dirtyAdjCoords.indexOf(misses.get(i)));
            }
        }

        for(int i = 0; i < hits.size(); i++) {
            if(dirtyAdjCoords.contains(hits.get(i))) {
                dirtyAdjCoords.remove(dirtyAdjCoords.indexOf(hits.get(i)));
            }
        }

        return dirtyAdjCoords;
    }

    private ArrayList<Point> hitLiveShipChecker(BattleshipModel cpuModel) {
        ArrayList<Ship> deadShips = cpuModel.getDestroyedPlayerShips();
        ArrayList<Point> hits = cpuModel.getComputerHits();
        Point temp;

        for(int i = 0; i < deadShips.size(); i++) {
            for(int j = 0; j < deadShips.get(i).getLength(); j++) {
                temp = deadShips.get(i).getStart();
                //if current dead ship is horizontal
                if(deadShips.get(i).getStart().getRow() == deadShips.get(i).getEnd().getRow()) {
                    temp.setCol(temp.getCol() + j);

                    if(hits.contains(temp)) {
                        hits.remove(hits.indexOf(temp));
                    }
                }

                //else current dead ship is vertical
                else {
                    temp.setRow(temp.getRow() + j);

                    if(hits.contains(temp)) {
                        hits.remove(hits.indexOf(temp));
                    }
                }
            }
        }

        return hits;
    }

    private boolean fireOverlapChecker(BattleshipModel cpuModel, int row, int col) {
        ArrayList<Point> cpuHits = cpuModel.getComputerHits();
        ArrayList<Point> cpuMisses = cpuModel.getComputerMisses();

        for(int i = 0; i < cpuHits.size(); i++) {
            if((row == cpuHits.get(i).getRow()) && (col == cpuHits.get(i).getCol())) {
                return true;
            }
        }

        for(int i = 0; i < cpuMisses.size(); i++) {
            if((row == cpuMisses.get(i).getRow()) && (col == cpuMisses.get(i).getCol())) {
                return true;
            }
        }

        return false;
    }

        //Currently this AI will loop from left-top to every other space.
        // If statement for starting state at Point (0,0)
        //if (cpuFireRow == 0 && cpuFireCol == 0) {
        //    cpuFireCol += 2;
        //    return cpuTargetFired;
        //}

        //cpuTargetFired.setRow(cpuFireRow);
        //cpuTargetFired.setCol(cpuFireCol);
        //cpuFireCol += 2;
        //if (cpuFireCol > numCol) {
        //    cpuFireRow += 1;
        //    cpuFireCol -= numCol;
        //    if (numCol % 2 == 0) {
        //        if (cpuFireRow % 2 == 0){
        //            cpuFireCol += 1;
        //        }
        //        else {
        //            cpuFireCol -= 1;
        //        }
        //    }
        //}
        //if (cpuFireRow > numRow) {
        //    cpuFireRow -= numRow;
        //}
        //return cpuTargetFired;


    // When fire function is called, the AI targetDeterminator will be called
    //public Point fire() {
    //    cpuTargetFired = targetDeterminator();
    //    return cpuTargetFired;
    //}


    /*
    * computer begins with random choosing location to fire at on the players's board.
    * if the computer hits a ship w/ its fire, then, it will try to sink the ship.
    * the computer must adhere to the player rules of battleship. the computer cannot "cheat"
    * by seeing the location of the player's bound or ship. These are the requirements of project 4.
    * */

    //public boolean levelOfDifficulty(boolean difficulty_hard) {
    //    if (difficulty_hard) {
            //if(1 == 1) {
            //; // then, it will try to sink the ship.
            //}

    //        return true;
    //    } else if (!difficulty_hard) {
            // The user is playing the game on easy mode.
    //        return false;
    //    }
    //}

}
