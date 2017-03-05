package edu.oregonstate.cs361.battleship;

/**
 * Created by garcibru on 2/02/17.
 */
public class UserFire {

    // BattleshipModel, a ship array containing all cpu ships, the number of cpu ships, and the point where player fired.
    private BattleshipModel userModel;
    private Ship[] allCpuShips;
    private int numShips;
    private Point targetUserFired;

    // Constructor
    public UserFire (BattleshipModel userModel, String userFireUrl) {
        String[] urlStr = userFireUrl.split("/");
        this.userModel = userModel;
        this.targetUserFired= Utility.pointFromStr(urlStr[4], urlStr[5]);

        // Call setAllUserShips to add all the ships in Model to the Ship array.
        setAllCpuShips();
    }

    // This function add all the cpu ships in the model to the Ship array
    public void setAllCpuShips(){
        // CAN BE MODIFIED
        numShips = 5;
        allCpuShips = new Ship [numShips];
        allCpuShips[0] = userModel.getComputer_aircraftCarrier();
        allCpuShips[1] = userModel.getComputer_battleship();
        allCpuShips[2] = userModel.getComputer_cruiser();
        allCpuShips[3] = userModel.getComputer_destroyer();
        allCpuShips[4] = userModel.getComputer_submarine();
    }

    public BattleshipModel userFireBattleshipModel(){
        for (int i = 0; i < numShips; i++) {
            if (Utility.targetHit(allCpuShips[i].getStart(), allCpuShips[i].getEnd(), targetUserFired)) {
                userModel.addPlayerHits(targetUserFired);
                return userModel;
            }
        }
        userModel.addPlayerMisses(targetUserFired);
        return userModel;
    }
}
