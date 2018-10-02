package gof.behavior.command.example1;

public class ResizeCommand implements Command {
    private Receiver2 receiver;
    private int width, height;

    public ResizeCommand(Receiver2 receiver, int width, int height) {
        this.receiver = receiver;
        this.width = width;
        this.height = height;
    }

    @Override
    public void execute() {
        receiver.presentView(width, height);
    }
}
