package ru.relex.menu;

import ru.relex.console.ConsoleRenderer;
import ru.relex.db.GameStore;
import ru.relex.game.GameMain;
import ru.relex.game.GameRules;

public class NewGameCommand extends GameMain implements Command {
    /**
     * @param rules           правила игры
     * @param consoleRenderer вывод на экран
     * @param gameStore       хранилище сохраненных игр
     */
    public NewGameCommand(GameRules rules, ConsoleRenderer consoleRenderer, GameStore gameStore) {
        super(rules, consoleRenderer, gameStore);
    }
}
