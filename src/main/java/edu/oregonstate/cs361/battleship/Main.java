package edu.oregonstate.cs361.battleship;

import com.google.gson.Gson;
import spark.Request;
import java.util.HashMap;
import java.util.Map;
import static spark.Spark.*;

public class Main {

    // Static public Map, accessible for all classes
    // Map <String shipName, shipLength>
    public static Map<String, Integer> shipInfo;
    public static ComputerAI ai;
    public static void main(String[] args) {

        // This will instantiate a new AI once the program starts running
        // This will allow us to server the static pages such as index.html, app.js, etc.
        staticFiles.location("/public");
        // This will listen to GET requests to /model and return a clean new model
        get("/model", (req, res) -> newModel());

        // This will listen to POST requests and expects to receive a game model, as well as location to fire to
        post("/fire/:row/:col", (req, res) -> fireAt(req, ai));

        // This will listen to POST requests and expects to receive a game model, as well as location to place the ship
        post("/placeShip/:id/:row/:col/:orientation", (req, res) -> placeShip(req));

        // This weill listen to POST requests and expects to receive a game model, as well as location to scan
        post("/scan/:row/:col", (req, res) -> scan(req, ai));
    }
    // This function initialize map for shipName and its length
    private static void createShipInfo(){
        // CAN BE MODIFIED
        shipInfo = new HashMap<>();
        shipInfo.put("aircraftCarrier", 5);
        shipInfo.put("battleship", 4);
        shipInfo.put("clipper", 3);
        shipInfo.put("dinghy", 2);
        shipInfo.put("submarine", 2);
    }
    //This function return a new model
    private static String newModel() {
        Gson gson = new Gson();
        // Create Ship Info
        createShipInfo();
        BattleshipModel new_game = new BattleshipModel();
        ai = new ComputerAI();
        // Parse into JSON string
        String model = gson.toJson(new_game);
        return model;
    }


    // This controller takes a json object from the front end, and place the ship as requested, and then return the object.
    private static String placeShip(Request req) {
        Gson gson = new Gson();
        BattleshipModel userModel = Utility.getModelFromReq(req);
        String shipPlacementUrl = req.url();
        System.out.println(shipPlacementUrl);
        // Pass into UserShipPlacer
        UserShipPlacer placeShipment = new UserShipPlacer(userModel, shipPlacementUrl);
        BattleshipModel newModel= placeShipment.placeBattleshipModel();

        // Parse to JSON string
        String parsedNewModel = gson.toJson(newModel);
        return parsedNewModel;
    }

    // This controller takes a json object from the front end, and fire as requested, and return object.
    private static String fireAt(Request req, ComputerAI ai) {
        Gson gson = new Gson();
        BattleshipModel userModel = Utility.getModelFromReq(req);
        String userFireUrl = req.url();
        // Pass into UserFire
        UserFire userFire = new UserFire(userModel, userFireUrl);
        userModel = userFire.userFireBattleshipModel();
        // Pass into ComputerFire
        ComputerFire cpuFire = new ComputerFire(userModel);
        userModel = cpuFire.cpuFireBattleshipModel(ai);

        // Parse to JSON string
        String parsedNewModel = gson.toJson(userModel);
        return parsedNewModel;
    }

    private static String scan(Request req, ComputerAI ai) {
        Gson gson = new Gson();
        BattleshipModel userModel = Utility.getModelFromReq(req);
        String userScanUrl = req.url();
        // Pass into Scanner
        Scanner scanner = new Scanner(userModel, userScanUrl);
        userModel = scanner.userScanBattleshipModel();
        if (scanner.getScanned()) {
            ComputerFire cpuFire = new ComputerFire(userModel);
            userModel = cpuFire.cpuFireBattleshipModel(ai);
        }
        // Parse to JSON string
        String parsedNewModel = gson.toJson(userModel);
        return parsedNewModel;
    }
}

