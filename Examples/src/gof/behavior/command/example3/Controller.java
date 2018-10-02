package gof.behavior.command.example3;

import java.util.ArrayList;

/**
 * Created by Gal on 8/25/2017.
 */
class Controller {
    private ArrayList<BaseCommand> commands;

    Controller() {
        commands = new ArrayList<>();
    }

    void addCommand(BaseCommand newCommand) {
        this.commands.add(newCommand);
    }

    BaseCommand getCommandAt(int index) {
        return commands.get(index);
    }

    String getData() {
        StringBuilder stringBuilder = new StringBuilder();
        for (BaseCommand c : commands) {
            stringBuilder.append(c.sb.toString());
        }
        return stringBuilder.toString();
    }
}
