package edu.oregonstate.cs361.battleship;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Joshua Lioy on 3/18/2017.
 */
public class ComputerAITest {
    @Test
    public void targetDeterminator() {
        BattleshipModel b = new BattleshipModel();
        ComputerAI cai = new ComputerAI();
        Point p = cai.targetDeterminator(b);
    }
}