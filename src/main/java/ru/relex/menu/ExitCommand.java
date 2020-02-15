package ru.relex.menu;

public class ExitCommand implements Command {
    @Override
    public void start() {
        System.exit(0);
    }
}
