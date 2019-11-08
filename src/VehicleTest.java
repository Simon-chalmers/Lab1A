import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    Saab95 saab95;
    Volvo240 volvo240;

    public VehicleTest(){
        saab95 = new Saab95();
        volvo240 = new Volvo240();
    }

    @org.junit.jupiter.api.Test
    void testSpeedFactor() {
        assertEquals(1.25, saab95.speedFactor());
        assertEquals(1.25, volvo240.speedFactor());
    }

    @org.junit.jupiter.api.Test
    void testMove() {
        assertEquals(50, saab95.xPosition);
        assertEquals(50, saab95.yPosition);
        saab95.move();
        assertEquals(51, saab95.xPosition);
        assertEquals(50, saab95.yPosition);

        assertEquals(100, volvo240.xPosition);
        assertEquals(100, volvo240.yPosition);
        volvo240.move();
        assertEquals(101, volvo240.xPosition);
        assertEquals(100, volvo240.yPosition);
    }

    @org.junit.jupiter.api.Test
    void testTurnLeft() {
        saab95.turnLeft();
        volvo240.turnLeft();
        for(int i=3; i>0; i--) {
            assertEquals(i, saab95.direction);
            saab95.turnLeft();
            assertEquals(i-1, saab95.direction);

            assertEquals(i, volvo240.direction);
            volvo240.turnLeft();
            assertEquals(i-1, volvo240.direction);
        }
    }

    @org.junit.jupiter.api.Test
    void testTurnRight() {
        for(int i=0; i<3; i++) {
            assertEquals(i, saab95.direction);
            saab95.turnRight();
            assertEquals(i+1, saab95.direction);

            assertEquals(i, volvo240.direction);
            volvo240.turnRight();
            assertEquals(i+1, volvo240.direction);
        }
    }
}