package gof.behavior.command.example2;

/**
 * Created by Gal on 8/25/2017.
 */
class Receiver {
    private boolean didGroot = false;

    void printBubu() {
        if (didGroot)
            System.out.println("Bubu is the king");
        else
            System.out.println("Illegal Print");
    }

    void printGroot() {
        didGroot = true;
        System.out.println("I am Groot");
    }


}
