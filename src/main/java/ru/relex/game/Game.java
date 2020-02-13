package ru.relex.game;

import ru.relex.console.ConsoleInput;
import ru.relex.console.ConsoleRenderer;
import ru.relex.player.Player;
import ru.relex.player.PlayerManager;

/**
 * Класс с основным игровым циклом
 */
public class Game {
    private ConsoleRenderer renderer;
    private GameRules gameRules;

    /**
     * @param rules правила игры
     * @param consoleRenderer вывод на экран
     */
    public Game(GameRules rules, ConsoleRenderer consoleRenderer) {
        this.gameRules = rules;
        this.renderer = consoleRenderer;
    }

    /**
     * Запуск новой игры
     */
    public void start() {
        renderer.renderRules();

        while (true) {
            PlayerManager playerManager = gameRules.getPlayerManager();
            Player player = playerManager.getActivePlayer();

            renderer.renderMap(playerManager.getPlayers());

            String message = String.format("Turn of %s[%s]. Available moves ", player.getName(), player.getIcon());
            String index = ConsoleInput.getCommand(message, gameRules.getAvailableMoves(player));

            player.move(Integer.parseInt(index));

            if (gameRules.isFinish()) {
                renderer.renderMap(playerManager.getPlayers());
                renderer.renderWinner(gameRules.getWinner());
                return;
            }

            playerManager.swapPlayers();
        }
    }
}
