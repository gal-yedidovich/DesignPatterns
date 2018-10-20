package gof.structural.proxy.example2;

/**
 * Created by Gal on 8/30/2017.
 */
public class Proxy2Test {
    public static void main(String[] args) {
        Driver gal = new Driver(15);
        Drivable car = new ProxyCar(gal);
        car.drive();

        gal.setAge(18);
        car.drive();
    }
}
