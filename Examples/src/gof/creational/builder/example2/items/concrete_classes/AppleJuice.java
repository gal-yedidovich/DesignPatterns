package gof.creational.builder.example2.items.concrete_classes;

import gof.creational.builder.example2.items.abstract_classes.ColdDrink;

/**
 * Created by Gal on 8/24/2017.
 */
public class AppleJuice extends ColdDrink {
    @Override
    public String getName() {
        return "Apple juice";
    }

    @Override
    public double getPrice() {
        return 6.90;
    }
}
