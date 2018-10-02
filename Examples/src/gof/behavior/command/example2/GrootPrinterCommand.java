package gof.behavior.command.example2;

/**
 * Created by Gal on 8/25/2017.
 */
public class GrootPrinterCommand implements PrintCommand {
    private Receiver mReceiver;

    public GrootPrinterCommand(Receiver mReceiver) {
        this.mReceiver = mReceiver;
    }

    @Override
    public void execute() {
        mReceiver.printGroot();
    }
}
