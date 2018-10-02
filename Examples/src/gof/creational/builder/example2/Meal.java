package gof.creational.builder.example2;

import gof.creational.builder.example2.items.abstract_classes.EatableItem;

import java.util.ArrayList;

/**
 * Created by Gal on 8/24/2017.
 */
public class Meal {
    private ArrayList<EatableItem> items = new ArrayList<>();

    void add(EatableItem item) {
        items.add(item);
    }

    public double getMealCost() {
        double cost = 0.0;
        for (EatableItem i : items) {
            cost += i.getPrice();
        }
        return cost;
    }

    void showMeal() {
        for (EatableItem i : items) {
            System.out.print("item: " + i.getName() + ", ");
            System.out.print("packing: " + i.getPacking().pack() + ", ");
            System.out.println("price: " + i.getPrice());
        }
    }
}
