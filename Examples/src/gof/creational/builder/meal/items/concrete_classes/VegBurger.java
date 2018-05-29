package gof.creational.builder.meal.items.concrete_classes;

import gof.creational.builder.meal.items.abstract_classes.Burger;

/**
 * Created by Gal on 8/24/2017.
 */
public class VegBurger extends Burger {
    @Override
    public String getName() {
        return "Veg Burger";
    }

    @Override
    public double getPrice() {
        return 30.0;
    }
}
