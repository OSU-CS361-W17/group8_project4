package edu.oregonstate.cs361.battleship;

import com.google.gson.Gson;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spark.Spark;
import spark.utils.IOUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static spark.Spark.awaitInitialization;

/**
 * Created by michaelhilton on 1/26/17.
 */
class MainTest {

    @BeforeAll
    public static void beforeClass() {
        Main.main(null);
        awaitInitialization();
    }

    @AfterAll
    public static void afterClass() {
        Spark.stop();
    }

    @Test
    public void testGetModel() {
        TestResponse res = request("GET", "/model");
        assertEquals(200, res.status);
        Gson gson = new Gson();
        BattleshipModel b = new BattleshipModel();
        String m = gson.toJson(b);
        assertEquals(m,res.body);
    }

    @Test@Ignore
    public void testPlaceShip() {
        TestResponse res = request("POST", "/placeShip/aircraftCarrier/1/1/horizontal");
        assertEquals(200, res.status);
        Gson gson = new Gson();
        BattleshipModel b = new BattleshipModel();
        b.aircraftCarrier.start.setAcross(1);
        b.aircraftCarrier.start.setDown(1);
        b.aircraftCarrier.start.setAcross(5);
        b.aircraftCarrier.start.setDown(1);

        String s = gson.toJson(b);
        assertEquals(s,res.body);
    }
    @Test
    public void testUserFire() {
        TestResponse res = request("Post", "/fire/1/2");
        assertEquals(200, res.status);
        assertEquals("Fired", res.body);
    }

    @Test
    void testCalcEnd() {

    }

    private TestResponse request(String method, String path) {
        try {
            URL url = new URL("http://localhost:4567" + path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            connection.setDoOutput(true);
            connection.connect();
            String body = IOUtils.toString(connection.getInputStream());
            return new TestResponse(connection.getResponseCode(), body);
        } catch (IOException e) {
            e.printStackTrace();
            fail("Sending request failed: " + e.getMessage());
            return null;
        }
    }

    private static class TestResponse {

        public final String body;
        public final int status;

        public TestResponse(int status, String body) {
            this.status = status;
            this.body = body;
        }

        public Map<String,String> json() {
            return new Gson().fromJson(body, HashMap.class);
        }
    }
}

