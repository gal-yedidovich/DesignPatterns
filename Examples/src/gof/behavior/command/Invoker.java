package gof.behavior.command;

public class Invoker {
    private int count = 0;

    public void doJob(Command cmd) {
        count++;
        cmd.execute();
    }

    public String getCount() {
        return count + " command executed";
    }
}
