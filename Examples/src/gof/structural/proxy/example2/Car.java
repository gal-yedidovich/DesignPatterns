package gof.structural.proxy.example2;

/**
 * Created by Gal on 8/30/2017.
 */
public class Car implements ICar {

    @Override
    public void drive() {
        System.out.println("Driving car!");
    }
}
