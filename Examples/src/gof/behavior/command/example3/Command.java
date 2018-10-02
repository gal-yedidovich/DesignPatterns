package gof.behavior.command.example3;

import java.util.Stack;

/**
 * Created by Gal on 8/25/2017.
 */


abstract class BaseCommand {
    final Stack<String> history = new Stack<>();
    final StringBuilder sb = new StringBuilder();

    abstract void execute(String text);

    abstract void undo();
}

class AddTextCommand extends BaseCommand {

    @Override
    public void execute(String text) {
        sb.append(text);
        history.push(text);
    }

    @Override
    public void undo() {
        //if there is something to undo
        if (history.isEmpty()) return;

        String lastAction = history.pop();
        int totalLength = sb.length();
        int entryLength = lastAction.length();
        sb.delete(totalLength - entryLength, totalLength);
    }
}

class AddNumbersCommand extends BaseCommand {

    @Override
    public void execute(String value) {
        sb.append(value);
        history.push(value);
    }

    @Override
    public void undo() {
        //if there is something to undo
        if (history.isEmpty()) return;

        String lastAction = history.pop();
        int totalLength = sb.length();
        int entryLength = lastAction.length();
        sb.delete(totalLength - entryLength, entryLength);
    }
}

