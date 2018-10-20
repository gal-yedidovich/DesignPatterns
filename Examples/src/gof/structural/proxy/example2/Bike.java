package gof.structural.proxy.example2;

public class Bike implements Drivable {
    @Override
    public void drive() {
        System.out.println("Bike drives");
    }
}
