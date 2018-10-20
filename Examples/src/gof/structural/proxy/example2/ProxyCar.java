package gof.structural.proxy.example2;

/**
 * Created by Gal on 8/30/2017.
 */
public class ProxyCar implements Drivable {
    private Drivable realCar;
    private Driver driver;

    public ProxyCar(Driver driver) {
        this.driver = driver;
        this.realCar = new Car();
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void drive() {
        if (driver.getAge() < 17) {
            System.out.println("driver is too young to drive");
        } else {
            realCar.drive();
        }
    }
}
