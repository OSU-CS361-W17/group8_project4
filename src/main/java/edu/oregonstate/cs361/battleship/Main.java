package edu.oregonstate.cs361.battleship;

import com.google.gson.Gson;
import spark.Request;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {

        //This will allow us to server the static pages such as index.html, app.js, etc.
        staticFiles.location("/public");

        //This will listen to GET requests to /model and return a clean new model
        get("/model", (req, res) -> newModel());

        //This will listen to POST requests and expects to receive a game model, as well as location to fire to
        post("/fire/:row/:col", (req, res) -> fireAt(req));

        //This will listen to POST requests and expects to receive a game model, as well as location to place the ship
        post("/placeShip/:id/:row/:col/:orientation", (req, res) -> placeShip(req));
    }

    //This function should return a new model
    static String newModel() {
        Gson gson = new Gson();
        BattleshipModel new_game = new BattleshipModel();
        String model = gson.toJson(new_game);
        return model;
    }

    //This function should accept an HTTP request and deserialize it into an actual Java object.
    private static BattleshipModel getModelFromReq(Request req){
        Gson gson = new Gson();
        String request_string = req.body();
        BattleshipModel model = gson.fromJson(request_string, BattleshipModel.class);
        return model;
    }

    //This controller should  take a json object from the front end, and place the ship as requested, and then return the object.
    private static String placeShip(Request req) {
        Gson gson = new Gson();

        BattleshipModel temp_model = getModelFromReq(req);
        String temp_url = req.url();
        int req_across = 0, req_down = 0;

        //Gets ship type from url
        System.out.println(temp_url);
        String ship_name = getShipName(temp_url);
        System.out.println(ship_name);
        //Gets placement coordinates from url
        int slash_count = 0;
        int curr_index = 0;
        for (int i = 0; i < temp_url.length(); i++) {
            if (temp_url.charAt(i) == '/' && slash_count < 5) {
                slash_count++;
                curr_index = i;
            }
        }
        char t1 = temp_url.charAt(curr_index + 1);
        char t2 = temp_url.charAt(curr_index + 3);
        req_across = Character.getNumericValue(t1);
        req_down = Character.getNumericValue(t2);
        Point temp_start = new Point(req_across, req_down);
        Point temp_end = new Point(0,0);
        //Gets orientation from url
        String orientation = getOrientation(temp_url);

        if (ship_name.equals("aircraftCarrier")) {
            temp_end = calcEnd(temp_start, orientation, 5);
            temp_model.aircraftCarrier.start = temp_start;
            temp_model.aircraftCarrier.end = temp_end;
        } else if (ship_name.equals("battleship")) {
            temp_end = calcEnd(temp_start, orientation, 4);
            temp_model.battleship.start = temp_start;
            temp_model.battleship.end = temp_end;
        } else if (ship_name.equals("cruiser")) {
            temp_end = calcEnd(temp_start, orientation, 3);
            temp_model.cruiser.start = temp_start;
            temp_model.cruiser.end = temp_end;
        } else if (ship_name.equals("destroyer")) {
            temp_end = calcEnd(temp_start, orientation, 2);
            temp_model.destroyer.start = temp_start;
            temp_model.destroyer.end = temp_end;
        } else if (ship_name.equals("submarine")) {
            temp_end = calcEnd(temp_start, orientation, 2);
            temp_model.submarine.start = temp_start;
            temp_model.submarine.end = temp_end;
        }

        return gson.toJson(temp_model);
    }

    public static String getShipName(String temp_url) {
        int slash_count = 0;
        int curr_index = 0;
        for (int i = 0; i < temp_url.length(); i++) {
            if (temp_url.charAt(i) == '/' && slash_count < 4) {
                slash_count++;
                curr_index = i + 1;
            }
        }
        String ship_name = temp_url.substring(curr_index, temp_url.length());
        slash_count = 0;
        curr_index = 0;
        for (int i = 0; i < ship_name.length(); i++) {
            if (ship_name.charAt(i) == '/' && slash_count < 1) {
                slash_count++;
                curr_index = i;
            }
        }
        return ship_name.substring(0, curr_index);
    }

    public static void getCoordinatesFromUrl(String temp_url, int a, int d) {
        int slash_count = 0;
        int curr_index = 0;
        for (int i = 0; i < temp_url.length(); i++) {
            if (temp_url.charAt(i) == '/' && slash_count < 4) {
                slash_count++;
                curr_index = i;
            }
        }
        char t1 = temp_url.charAt(curr_index + 1);
        char t2 = temp_url.charAt(curr_index + 3);
        a = Character.getNumericValue(t1);
        d = Character.getNumericValue(t2);
    }

    public static String getOrientation(String temp_url) {
        int slash_count = 0;
        int curr_index = 0;
        for (int i = 0; i < temp_url.length(); i++) {
            if (temp_url.charAt(i) == '/' && slash_count < 7) {
                slash_count++;
                curr_index = i + 1;
            }
        }
        return temp_url.substring(curr_index);
    }

    public static Point calcEnd(Point start, String orientation, int length) {
        Point temp = new Point(0,0);
        if (orientation.equals("horizontal")) {
            temp.setAcross(start.getAcross());
            temp.setDown((start.getDown()) + (length - 1));
        }
        else {
            temp.setAcross((start.getAcross()) + (length - 1));
            temp.setDown(start.getDown());
        }
        return temp;
    }
    //Similar to placeShip, but with firing.
    private static String fireAt(Request req) {
        UserFire userfire = new UserFire();
        return null;
    }

}

