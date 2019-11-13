import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LongLoader extends Scania {

    /**
     * Maximum amount of vehicle the truck can carry
     */
    private int maxVehicles = 6;
    /**
     * List of all the vehicles
     */
    private final List<AbstractVehicle> listVehicle = new ArrayList<>();

    LongLoader(){
        nrDoors = 2;
        color = Color.BLUE;
        enginePower = 800;
        modelName = "Scania Long Loader";
        xPosition = 100;
        yPosition = 100;
        direction = 0;
        weight = 12000;
        stopEngine();
    }

    /**
     * @param vehicle Adds vehicle to carry list
     */
    public void addVehicle(AbstractVehicle vehicle){
        if(listVehicle.size() < maxVehicles && isLoadable(vehicle)){
            listVehicle.add(vehicle);
            vehicle.xPosition = xPosition;
            vehicle.yPosition = yPosition;
            vehicle.direction = direction;
        }
    }

    /**
     * Removes the last vehicle that entered the carry list
     */
    public void removeVehicle(){
        if(listVehicle.size() > 0 && platformTilt == 0){
            listVehicle.get(listVehicle.size() - 1).xPosition -= listVehicle.size();
            listVehicle.remove(listVehicle.size()-1);
        }
    }

    /**
     * @param vehicle Checks if vehicle is loadable
     * @return
     */
    private boolean isLoadable(AbstractVehicle vehicle) {
        return vehicle.weight < 3000 && isNearby(vehicle) && platformTilt == 0;
    }

    /**
     * @param vehicle Checks if vehicle is nearby
     * @return
     */
    private boolean isNearby(AbstractVehicle vehicle) {
        if(vehicle.xPosition > xPosition - 10 && vehicle.xPosition < xPosition + 10){
            if(vehicle.yPosition > yPosition - 10 && vehicle.yPosition < yPosition + 10){
                return true;
            }
        }
        return false;
    }

    /**
     * @return Returns the list of vehicles
     */
    public List<AbstractVehicle> getListVehicle(){
        return listVehicle;
    }

    @Override
    public void move() {
        switch (direction){
            case 0:
                xPosition++;
                break;
            case 1:
                yPosition++;
                break;
            case 2:
                xPosition--;
                break;
            case 3:
                yPosition--;
                break;
        }
        for(AbstractVehicle vehicle : listVehicle){
            vehicle.move();
        }
    }

    @Override
    public void turnLeft(){
        direction = ((((direction-1) % 4) + 4) % 4);

        for(AbstractVehicle vehicle : listVehicle){
            vehicle.turnLeft();
        }
    }

    @Override
    public void turnRight(){
        direction = (direction+1)%directions.length;

        for(AbstractVehicle vehicle : listVehicle){
            vehicle.turnRight();
        }
    }

}
