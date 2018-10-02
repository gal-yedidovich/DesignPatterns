package gof.behavior.observer.example1;

/**
 * Created by Gal on 8/25/2017.
 */
public class Test {
    public static void main(String[] args) {
        //create object that can update observers
        Subject observee = new Subject();

        //attach apple observer
        new AppleObserver(observee);
        observee.setName("Gal");

        //attach banana observer
        new BananaObserver(observee);
        observee.setName("Nevoa");
    }
}
