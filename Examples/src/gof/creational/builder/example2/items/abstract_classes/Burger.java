package gof.creational.builder.example2.items.abstract_classes;

import gof.creational.builder.example2.packing.Packing;
import gof.creational.builder.example2.packing.Wrapper;

/**
 * Created by Gal on 8/24/2017.
 */
public abstract class Burger implements EatableItem{
    @Override
    public Packing getPacking() {
        return new Wrapper();
    }

    @Override
    public abstract double getPrice();
}
