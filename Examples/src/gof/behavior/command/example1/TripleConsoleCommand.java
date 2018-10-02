package gof.behavior.command.example1;

public class TripleConsoleCommand implements Command {
    private Receiver1 receiver;
    private String str;

    public TripleConsoleCommand(Receiver1 receiver, String str) {
        this.receiver = receiver;
        this.str = str;
    }

    @Override
    public void execute() {
        for (int i = 0; i < 3; i++)  receiver.print(str);
        System.out.println();
    }
}
