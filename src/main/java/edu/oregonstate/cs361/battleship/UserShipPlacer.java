package edu.oregonstate.cs361.battleship;

import static edu.oregonstate.cs361.battleship.Main.shipInfo;

/**
 * Created by jerry on 2/4/2017.
 */

public class UserShipPlacer {

    // BattleshipModel, ship name, starting and ending coordinates
    private BattleshipModel userModel;
    private String shipName;
    private Point start;
    private Point end;

    public UserShipPlacer (BattleshipModel userModel, String shipPlacementUrl) {
        String[] urlStr = shipPlacementUrl.split("/");
        this.userModel = userModel;
        this.shipName =  urlStr[4];
        this.start = Utility.pointFromStr(urlStr[5], urlStr[6]);
        this.end = Utility.endPointFromStr(urlStr[5], urlStr[6], urlStr[7], shipName);
    }

    public BattleshipModel placeBattleshipModel() {
        Ship newShip = new Ship(shipName, shipInfo.get(shipName), start, end);
        if (shipName.equals("aircraftCarrier")) {
            userModel.setAircraftCarrier(newShip);
        }
        else if (shipName.equals("battleship")) {
            userModel.setBattleship(newShip);
        }
        else if (shipName.equals("clipper")) {
            userModel.setClipper(newShip);
        }
        else if (shipName.equals("dinghy")) {
            userModel.setDinghy(newShip);
        }
        else if (shipName.equals("submarine")) {
            userModel.setSubmarine(newShip);
        }
        return userModel;
    }
}
