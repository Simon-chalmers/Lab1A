import org.w3c.dom.ls.LSOutput;

public interface IMovable {

    /**
     * Moves the car in a specific direction.
     */
    void move();

    /**
     * Turn the car 90 degrees left
     */
    void turnLeft();

    /**
     * Turn the car 90 degrees right
     */
    void turnRight();


}
