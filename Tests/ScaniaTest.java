import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    private Scania scania;

    public ScaniaTest(){
        scania = new Scania();
    }

    @Test
    void testSpeedFactor() {
        assertEquals(5.0, scania.speedFactor());
    }

    @Test
    void testStartEngine() {
        assertEquals(0.0, scania.currentSpeed);
        scania.startEngine();
        assertEquals(0.1, scania.currentSpeed);
    }

    @Test
    void testGas() {
        scania.startEngine();
        assertEquals(0.1, scania.currentSpeed);
        scania.gas(1);
        assertEquals(5.1, scania.currentSpeed);
    }

    @Test
    void lowerPlatform() {
        assertEquals(0, scania.getPlatformTilt());
        scania.risePlatform();
        scania.lowerPlatform();
        assertEquals(0, scania.getPlatformTilt());
    }

    @Test
    void risePlatform() {
        assertEquals(0, scania.getPlatformTilt());
        scania.risePlatform();
        assertEquals(1, scania.getPlatformTilt());
    }
}