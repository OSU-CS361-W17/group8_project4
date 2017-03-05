package edu.oregonstate.cs361.battleship;

import java.util.ArrayList;

/**
 * Created by jerry on 3/4/2017.
 */
public class Scanner {
    private BattleshipModel userModel;
    private Ship[] allCpuShips;
    private int numShips;
    private Point targetUserScanned;
    private Boolean scanned;

    public Scanner(BattleshipModel userModel, String userScanUrl) {
        String[] urlStr = userScanUrl.split("/");
        this.userModel = userModel;
        this.targetUserScanned = Utility.pointFromStr(urlStr[4], urlStr[5]);

        // Call setAllUserShips to add all the ships in Model to the Ship array.
        setAllCpuShips();
    }

    // Return if the object scanned the board
    public Boolean getScanned() { return scanned; }

    // This function add all the cpu ships in the model to the Ship array
    public void setAllCpuShips(){
        // CAN BE MODIFIED
        scanned = false;
        numShips = 5;
        allCpuShips = new Ship [numShips];
        allCpuShips[0] = userModel.getComputer_aircraftCarrier();
        allCpuShips[1] = userModel.getComputer_battleship();
        allCpuShips[2] = userModel.getComputer_clipper();
        allCpuShips[3] = userModel.getComputer_dinghy();
        allCpuShips[4] = userModel.getComputer_submarine();
    }

    public BattleshipModel userScanBattleshipModel() {
        // If there are no scans available, return
        if (!userModel.scansAvailable()) {
            return userModel;
        }
        scanned = true;
        int row = targetUserScanned.getRow();
        int col = targetUserScanned.getCol();

        // Add the scanned coordinate to scanPos array in userModel
        userModel.addScanPos(targetUserScanned);

        // Initialize variable for start/end row/col
        int rowStart = row - 1;
        int rowEnd = row + 1;
        int colStart = col - 1;
        int colEnd = col + 1;
        if(rowStart < 1) rowStart = 1;
        if(rowEnd > 10) rowEnd = 10;
        if(colStart < 1) colStart = 1;
        if(colEnd > 10) colEnd = 10;

        // For each 3-by-3 square around the coordinate scanned, see if there are ships, and add coordinate to arrays accordingly
        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = colStart; j <= colEnd; j++) {
                Boolean hit = false;
                Point target = new Point(i, j);
                for (int k = 0; k < numShips; k++) {
                    if (Utility.targetHit(allCpuShips[k].getStart(), allCpuShips[k].getEnd(), target)) {
                        userModel.addScanHits(target);
                        hit = true;
                        break;
                    }
                }
                if(!hit){
                    userModel.addScanMisses(target);
                }
            }
        }
        ArrayList<Point> temp = userModel.getScanMisses();
        System.out.println(temp.size());
        for(int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i).getRow());
            System.out.println(temp.get(i).getCol());
        }
        return userModel;
    }
}
