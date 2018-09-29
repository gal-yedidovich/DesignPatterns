package gof.creational.factory_method.car_factory.vehicles;

public class VehicleFactory {

    public Vehicle createVehicle(String name) {
        if (name == null) return new Car();

        switch (name.toLowerCase()) {
            case "car":
            case "private":
                return new Car();
            case "bike":
            case "motor":
                return new Bike();
            case "truck":
                return new Truck();
            default:
                return new Car();
        }
    }
}
