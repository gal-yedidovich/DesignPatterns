package gof.creational.factory_method.pizza_factory.pizza;

/**
 * Created by Gal on 8/23/2017.
 */
public class PizzaFactory {

    //example 1: only configure with no subclasses
    public Pizza createIsraeliPizza() {
        IsraeliPizza ip = new IsraeliPizza();
        ip.toppings = new String[]{"Olives", "Onions", "Mozzarella"};
        ip.size = PizzaSize.Huge;
        return ip;
    }

    //example 2: with subclasses
    public Pizza createPizza(String location) {
        Pizza new_pizza;
        switch (location.toLowerCase()) {
            case "newyork":
                new_pizza = new NewYorkPizza();
                new_pizza.size = PizzaSize.Large;
                break;

            case "italian":
                new_pizza = new ItalianPizza();
                new_pizza.size = PizzaSize.Huge;
                break;

            case "israeli":
                new_pizza = new IsraeliPizza();
                new_pizza.size = PizzaSize.Small;
                break;

            default:
                throw new IllegalArgumentException("unknown pizza");
        }

        return new_pizza;
    }
}
