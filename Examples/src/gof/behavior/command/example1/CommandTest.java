package gof.behavior.command.example1;

public class CommandTest {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Receiver1 console = new Receiver1();
        Receiver2 window = new Receiver2();

        invoker.doJob(new ResizeCommand(window, 400, 300));
        invoker.doJob(new TripleConsoleCommand(console, "hello world three times"));

        System.out.println(invoker.getCount());
    }
}
