package gof.behavior.observer.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gal on 8/25/2017.
 */
public class Subject {
    private List<Observer> observers;
    private String name;

    Subject() {
        observers = new ArrayList<>();
    }

    void attach(Observer o) {
        observers.add(o);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyObservers();
    }

    private void notifyObservers() {
        System.out.println("Notifying observers:");

        for (Observer o : observers)
            o.update();

        System.out.println();
    }
}
