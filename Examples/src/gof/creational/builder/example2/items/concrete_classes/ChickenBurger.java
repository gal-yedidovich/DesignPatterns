package gof.creational.builder.example2.items.concrete_classes;

import gof.creational.builder.example2.items.abstract_classes.Burger;

/**
 * Created by Gal on 8/24/2017.
 */
public class ChickenBurger extends Burger {
    @Override
    public String getName() {
        return "Chicken Burger";
    }

    @Override
    public double getPrice() {
        return 35.50;
    }
}
