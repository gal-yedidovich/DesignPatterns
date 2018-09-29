package gof.creational.factory_method.car_factory;

import gof.creational.factory_method.car_factory.vehicles.Vehicle;
import gof.creational.factory_method.car_factory.vehicles.VehicleFactory;

public class Test {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();

        Vehicle v1 = factory.createVehicle("car");
        Vehicle v2 = factory.createVehicle("PriVAtE");

        Vehicle[] vehicles = {
                v1, v2,
                factory.createVehicle("motor"),
                factory.createVehicle("truck"),
        };

        for(Vehicle v : vehicles) v.drive();
    }
}
