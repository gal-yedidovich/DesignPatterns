package gof.behavior.observer.example1;

/**
 * Created by Gal on 8/25/2017.
 */
public class AppleObserver extends Observer {
    private int nameLength;

    protected AppleObserver(Subject subject) {
        super(subject);
    }

    @Override
    void update() {
        String currentName = subject.getName();
        System.out.println("Apple " + currentName);
        nameLength = currentName.length();
    }
}
