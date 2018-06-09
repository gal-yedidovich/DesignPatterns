package gof.behavior.observer2;

import java.util.ArrayList;

public class Subject {
    private String name;

    private ArrayList<OnNameChanged> nameObservers = new ArrayList<>();

    public void attach(OnNameChanged listener) {
        nameObservers.add(listener);
    }

    public void setName(String name) {
        this.name = name;
        notifyNameChanged();
    }

    private void notifyNameChanged() {
        for (OnNameChanged o : nameObservers) o.handleNameChanged(name);
        System.out.println();
    }

    public interface OnNameChanged {
        void handleNameChanged(String name);
    }
}
