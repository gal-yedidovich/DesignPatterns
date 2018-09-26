package gof.behavior.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Caretaker
 */
public class MementoTester {
    public static void main(String[] args) {
        List<Originator.Memento> history = new ArrayList<>();

        Originator o = new Originator();
        o.setData("Bubu");
        history.add(o.saveToMemento());
        o.setData("Groot");
        history.add(o.saveToMemento());
        o.setData("Deadpool");
        history.add(o.saveToMemento());

        System.out.println(o.getData());
        o.setData(history.get(0).getData());
        System.out.println(o.getData());
    }
}
