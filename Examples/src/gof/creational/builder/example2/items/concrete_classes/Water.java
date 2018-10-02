package gof.creational.builder.example2.items.concrete_classes;

import gof.creational.builder.example2.items.abstract_classes.ColdDrink;

/**
 * Created by Gal on 8/24/2017.
 */
public class Water extends ColdDrink {
    @Override
    public String getName() {
        return "Cold Water";
    }

    @Override
    public double getPrice() {
        return 4.50;
    }
}
