package gof.creational.builder.example2;

/**
 * Created by Gal on 8/24/2017.
 */
public class Test {
    public static void main(String[] args) {
        MealBuilder builder = new MealBuilder();
        Meal vegMeal = builder.buildVegMeal();
        vegMeal.showMeal();
        System.out.println(vegMeal.getMealCost());

        Meal chickenMeal = builder.buildChickenMeal();
        chickenMeal.showMeal();
        System.out.println(chickenMeal.getMealCost());
    }
}
