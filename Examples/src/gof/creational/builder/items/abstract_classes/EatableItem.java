package gof.creational.builder.items.abstract_classes;

import gof.creational.builder.packing.Packing;

/**
 * Created by Gal on 8/24/2017.
 */
public interface EatableItem {
    String getName();

    Packing getPacking();

    double getPrice();
}

