package gof.behavior.command.example2;

/**
 * Created by Gal on 8/25/2017.
 */
public class PrintInvoker {
    public void invokeCommand(PrintCommand command) {
        command.execute();
    }
}
