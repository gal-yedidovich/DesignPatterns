package gof.behavior.command.example2;

/**
 * Created by Gal on 8/25/2017.
 */
public class BubuPrinterCommand implements PrintCommand {
    private Receiver mReceiver;

    public BubuPrinterCommand(Receiver mReceiver) {
        this.mReceiver = mReceiver;
    }

    @Override
    public void execute() {
        mReceiver.printBubu();
    }
}
