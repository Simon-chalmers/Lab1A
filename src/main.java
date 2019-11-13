public class main {

    public static void main(String[] args){
        Saab95 saab95 = new Saab95();
        Volvo240 volvo240 = new Volvo240();

        System.out.println(saab95.direction);
        System.out.println(saab95.currentSpeed);
        saab95.turnRight();
        saab95.gas(1);
        System.out.println(saab95.direction);
        System.out.println(saab95.currentSpeed);
        saab95.turnRight();
        System.out.println(saab95.direction);
        System.out.println(saab95.currentSpeed);
        saab95.turnRight();
        saab95.gas(1);
        System.out.println(saab95.direction);
        System.out.println(saab95.currentSpeed);
        saab95.turnRight();
    }
}
