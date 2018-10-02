package gof.structural.proxy.example2;

/**
 * Created by Gal on 8/30/2017.
 */
public class Test {
    public static void main(String[] args) {
        ProxyCar car = new ProxyCar(new Driver(15));
        car.drive();

        car.setDriver(new Driver(18));
        car.drive();
    }
}
