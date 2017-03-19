package edu.oregonstate.cs361.battleship;

import com.google.gson.Gson;
import spark.Request;

import static edu.oregonstate.cs361.battleship.Main.shipInfo;

/**
 * Created by jerry on 2/4/2017.
 */

/*
    This class Utility is for any function that can be used in all classes
 */
public class Utility {

/*
    This function accepts an HTTP request and deserializes it into an actual Java object.
 */
    public static BattleshipModel getModelFromReq(Request req){
        Gson gson = new Gson();
        String request_string = req.body();
        BattleshipModel model = gson.fromJson(request_string, BattleshipModel.class);
        return model;
    }
/*
    This function take two string containing numeric value and return a Point object
    Arguments: String col, String row
    return: A Point object
 */
    public static Point pointFromStr(String row, String col) {
        int rowInt = Integer.parseInt(row);
        int colInt = Integer.parseInt(col);
        Point newPoint = new Point(rowInt, colInt);
        return newPoint;
    }
/*
    This function takes argument, determine end point, and return it
    Arguments: String row, string col
    return: A point object (endPoint for ships)
 */
    public static Point endPointFromStr(String row, String col, String orientation, String shipName) {
        int rowInt = Integer.parseInt(row);
        int colInt = Integer.parseInt(col);
        int length = shipInfo.get(shipName);
        if (orientation.equals("horizontal")){
            colInt += (length - 1);
        }
        else {
            rowInt += (length - 1);
        }
        Point newPoint = new Point(rowInt, colInt);
        return newPoint;
    }

/*
    This function takes 3 arguments, determine if the ship is fired, and return a boolean
    Argument: Point start, Point end, Point fired
    return: boolean (if hit: 1; if miss: 0)
 */
    public static boolean targetHit(Point start, Point end, Point fired) {
        // If the ship is horizontal
        if (start.getRow() == end.getRow()) {
            if (fired.getRow() != start.getRow()) {
                return false;
            }
            if (fired.getCol() < start.getCol() || fired.getCol() > end.getCol()) {
                return false;
            }
        }

        // If the ship is vertical
        else {
            if (fired.getCol() != start.getCol()) {
                return false;
            }
            if (fired.getRow() < start.getRow() || fired.getRow() > end.getRow()) {
                return false;
            }
        }

        // If the point pass all the tests above, that means the point is a hit.
        return true;
    }

}
