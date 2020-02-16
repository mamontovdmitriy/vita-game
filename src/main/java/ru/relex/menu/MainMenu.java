package ru.relex.menu;

import ru.relex.console.ConsoleInput;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MainMenu {
    private List<MenuItem> menuItems;

    public MainMenu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    /**
     * Главное меню
     */
    public void show() {
        while (true) {
            render();

            String alias = ConsoleInput.getCommand("Your choice", allowedCommand());

            getCurrentMenuItem(alias).getCommand().start();
        }
    }

    private Collection<String> allowedCommand() {
        return menuItems.stream().map(MenuItem::getAlias).collect(Collectors.toList());
    }

    private MenuItem getCurrentMenuItem(String alias) {
        return menuItems.stream()
                .filter((a) -> alias.equals(a.getAlias()))
                .findFirst()
                .get();
    }

    private void render() {
        System.out.println("\n-= Main menu =-");
        for (MenuItem item : menuItems) {
            System.out.printf("%s - %s\n", item.getAlias(), item.getLabel());
        }
    }
}
