import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongLoaderTest {

    private LongLoader truck;

    public LongLoaderTest(){
        truck = new LongLoader();
    }

    @Test
    void addVehicle() {
        assertEquals(0, truck.getListVehicle().size());
        truck.addVehicle(new Volvo240());
        assertEquals(1, truck.getListVehicle().size());
    }

    @Test
    void removeVehicle() {
        truck.addVehicle(new Volvo240());
        truck.removeVehicle();
        assertEquals(0, truck.getListVehicle().size());
    }

    @Test
    void move() {
        truck.addVehicle(new Volvo240());
        for(AbstractVehicle vehicle : truck.getListVehicle()){
            assertEquals(truck.xPosition, vehicle.xPosition);
            assertEquals(truck.yPosition, vehicle.yPosition);
        }
        truck.move();
        for(AbstractVehicle vehicle : truck.getListVehicle()){
            assertEquals(truck.xPosition, vehicle.xPosition);
            assertEquals(truck.yPosition, vehicle.yPosition);
        }
    }

    @Test
    void turnLeft() {
        truck.addVehicle(new Volvo240());
        for(AbstractVehicle vehicle : truck.getListVehicle()){
            assertEquals(truck.direction, vehicle.direction);
        }
        truck.turnLeft();
        for(AbstractVehicle vehicle : truck.getListVehicle()){
            assertEquals(truck.direction, vehicle.direction);
        }
    }

    @Test
    void turnRight() {
        truck.addVehicle(new Volvo240());
        for(AbstractVehicle vehicle : truck.getListVehicle()){
            assertEquals(truck.direction, vehicle.direction);
        }
        truck.turnRight();
        for(AbstractVehicle vehicle : truck.getListVehicle()){
            assertEquals(truck.direction, vehicle.direction);
        }
    }
}