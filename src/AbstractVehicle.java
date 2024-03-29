import org.w3c.dom.ls.LSOutput;

import java.awt.*;

abstract public class AbstractVehicle implements IMovable{

    /**
     * Number of doors on the car
     */
    int nrDoors;
    /**
     *  Engine power of the car
     */
    double enginePower;
    /**
     * The current speed of the car
     */
    double currentSpeed;
    /**
     * Color of the car
     */
    Color color;
    /**
     * The car model name
     */
    String modelName;
    /**
     * X position of car
     */
    int xPosition;
    /**
     * Y position of car
     */
    int yPosition;
    /**
     *  Matrix of dx,dy directions
     */
    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    /**
     * Current direction of car
     */
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

    /**
     * Starts the engine
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     *  Stops the engine
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * @return Returns the current speedfactor
     */
    abstract double speedFactor();


    /**
     * @param amount    Factor for incrementing speed.
     */
    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /**
     * @param amount    Factor for decrementing speed.
     */
    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }


    /**
     * @param amount    Gas factor, must be [0,1]
     */
    public void gas(double amount){
        if(amount >= 0 && amount <= 1)
            incrementSpeed(amount);
    }

    /**
     * @param amount    Brake factor, must be [0,1]
     */
    public void brake(double amount){
        if(amount >= 0 && amount <= 1)
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
