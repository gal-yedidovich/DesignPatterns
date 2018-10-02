package gof.behavior.command.example3;

/**
 * Created by Gal on 8/25/2017.
 */
public class Test {
    public static void main(String[] args) {
        Controller cont = new Controller();
        cont.addCommand(new AddTextCommand());
        cont.addCommand(new AddNumbersCommand());

        cont.getCommandAt(0).execute("text 1\n");
        cont.getCommandAt(0).execute("text 2\n");
        cont.getCommandAt(1).execute("Number Text 3\n");

        cont.getCommandAt(0).undo();
        System.out.println(cont.getData());
    }
}
