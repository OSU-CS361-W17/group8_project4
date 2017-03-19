package edu.oregonstate.cs361.battleship;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Joshua Lioy on 3/18/2017.
 */
public class UtilityTest {
    @Test
    public void testUtil() {
        Utility util = new Utility();
        String row = "1";
        String col = "1";
        String name = "ship";
        String orient = "horz";

        Point p1 = util.pointFromStr(row, col);
        assertEquals(1, p1.getRow());
        assertEquals(1, p1.getCol());
    }
}