package gof.behavior.observer.example2;

public class LengthObserver implements Subject.OnNameChanged{

    @Override
    public void handleNameChanged(String name) {
        if(name.length() >= 5) System.out.println("name has at least 5 letters");
    }
}
