import org.w3c.dom.ls.LSOutput;

import java.awt.*;

abstract public class AbstractVehicle implements IMovable{

    enum Direction {RIGHT, DOWN, LEFT, UP};

    int nrDoors; // Number of doors on the car
    double enginePower; // Engine power of the car
    double currentSpeed; // The current speed of the car
    Color color; // Color of the car
    String modelName; // The car model name
    int xPosition;  //  X position of car
    int yPosition;  //  Y position of car
    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    int direction;

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    private double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    abstract double speedFactor();


    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
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
    }

    @Override
    public void turnLeft() {
        direction = ((((direction-1) % 4) + 4) % 4);
    }

    @Override
    public void turnRight() {
        direction = (direction+1)%directions.length;
    }
}
