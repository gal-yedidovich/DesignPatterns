package gof.behavior.observer.example2;

public class Tester {
    public static void main(String[] args) {
        Subject sbj = new Subject();
        sbj.attach(new LengthObserver());

        sbj.attach(name -> {
            if ("Gal".equalsIgnoreCase(name)) {
                System.out.println("name is now Gal, which is cool");
            }
        });

        sbj.attach(n -> System.out.println("event handled, " + n));

        sbj.setName("Bubu");
        sbj.setName("GAL");
        sbj.setName("Deadpool");
    }
}
