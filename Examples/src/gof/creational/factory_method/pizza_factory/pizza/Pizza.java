package gof.creational.factory_method.pizza_factory.pizza;

import java.util.Arrays;

/**
 * Created by Gal on 8/23/2017.
 */
public abstract class Pizza {
    protected PizzaSize size;
    protected String[] toppings;

    public void setToppings(String[] toppings) {
        this.toppings = toppings;
    }

    Pizza() {
    }

    @Override
    public String toString() {
        return "Pizaa - size: " + size + ", toppings: " + Arrays.toString(toppings);
    }
}

enum PizzaSize {
    Small, Large, Huge
}

class IsraeliPizza extends Pizza {
    public boolean isKosher() {
        for (String top : toppings) {
            if ("bacon".equalsIgnoreCase(top) || "tuna".equalsIgnoreCase(top))
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Israeli " + super.toString() + "\nPizza is" + (isKosher() ? " " : " Not ") + "kosher";
    }
}

class NewYorkPizza extends Pizza {

    public double getPerimeter() {
        return (size.ordinal() + 1) * 1.15;
    }
}

class ItalianPizza extends Pizza {
    private boolean hasMeat;

    public boolean isHasMeat() {
        return hasMeat;
    }

    public void setHasMeat(boolean hasMeat) {
        this.hasMeat = hasMeat;
    }
}
