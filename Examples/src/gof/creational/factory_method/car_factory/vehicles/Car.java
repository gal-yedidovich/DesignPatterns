package gof.creational.factory_method.car_factory.vehicles;

class Car implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Car drives");
    }
}
