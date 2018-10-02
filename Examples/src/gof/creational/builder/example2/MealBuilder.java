package gof.creational.builder.example2;

import gof.creational.builder.example2.items.concrete_classes.AppleJuice;
import gof.creational.builder.example2.items.concrete_classes.ChickenBurger;
import gof.creational.builder.example2.items.concrete_classes.VegBurger;
import gof.creational.builder.example2.items.concrete_classes.Water;

/**
 * Created by Gal on 8/24/2017.
 */
public class MealBuilder {
    public Meal buildVegMeal() {
        Meal m = new Meal();
        m.add(new VegBurger());
        m.add(new Water());
        return m;
    }

    public Meal buildChickenMeal() {
        Meal m = new Meal();
        m.add(new ChickenBurger());
        m.add(new AppleJuice());
        return m;
    }
}
