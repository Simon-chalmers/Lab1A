import java.awt.*;

public class Scania extends AbstractVehicle {

    /**
     * Tilt of Trucks platform
     */
    int platformTilt = 0;

    /**
     * Max Tilt of Trucks platform
     */
    int platformMaxTilt = 70;

    public Scania(){
        nrDoors = 2;
        color = Color.orange;
        enginePower = 500;
        modelName = "Scania";
        xPosition = 150;
        yPosition = 150;
        direction = 0;
        weight = 8000;
        stopEngine();
    }

    @Override
    double speedFactor() {
        return enginePower * 0.01;
    }

    @Override
    public void startEngine(){
        if(platformTilt == 0){
            currentSpeed = 0.1;
        }
    }

    @Override
    public void gas(double amount){
        if(platformTilt == 0){
            if(amount >= 0 && amount <= 1)
                incrementSpeed(amount);
        }
    }

    /**
     * @return Current tilt of platform
     */
    public int getPlatformTilt(){
        return platformTilt;
    }

    /**
     * Lower the platform
     */
    public void lowerPlatform(){
        if(platformTilt > 0 && currentSpeed == 0){
            platformTilt--;
        }
    }

    /**
     * Rise the platform
     */
    public void risePlatform(){
        if(platformTilt < platformMaxTilt && currentSpeed == 0){
            platformTilt++;
        }
    }
}
