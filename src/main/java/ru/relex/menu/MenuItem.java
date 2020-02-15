package ru.relex.menu;

public class MenuItem {
    private String alias;
    private String label;
    private Command command;

    public MenuItem(String alias, String label, Command command) {
        this.alias = alias;
        this.label = label;
        this.command = command;
    }

    public String getAlias() {
        return alias;
    }

    public String getLabel() {
        return label;
    }

    public Command getCommand() {
        return command;
    }
}
