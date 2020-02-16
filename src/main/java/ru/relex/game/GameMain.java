package ru.relex.game;

import ru.relex.console.ConsoleInput;
import ru.relex.console.ConsoleRenderer;
import ru.relex.db.Entity.Game;
import ru.relex.db.GameStore;
import ru.relex.player.Player;
import ru.relex.player.PlayerManager;

/**
 * Класс с основным игровым циклом
 */
public class GameMain {
    private ConsoleRenderer renderer;
    private GameRules gameRules;
    private GameStore gameStore;

    /**
     * @param rules правила игры
     * @param consoleRenderer вывод на экран
     * @param gameStore хранилище сохраненных игр
     */
    public GameMain(GameRules rules, ConsoleRenderer consoleRenderer, GameStore gameStore) {
        this.gameRules = rules;
        this.renderer = consoleRenderer;
        this.gameStore = gameStore;
    }

    /**
     * Запуск новой игры
     */
    public void start() {
        int moveNumber = 1;
        Game game = gameStore.createSavedGame();

        gameRules.init();
        renderer.renderRules();

        while (true) {
            PlayerManager playerManager = gameRules.getPlayerManager();
            Player player = playerManager.getActivePlayer();

            renderer.renderMap(playerManager.getPlayers());

            String message = String.format("Turn of %s[%s]. Available moves ", player.getName(), player.getIcon());
            String index = ConsoleInput.getCommand(message, gameRules.getAvailableMoves(player));

            player.move(Integer.parseInt(index));

            gameStore.saveMove(game, player, Integer.parseInt(index), moveNumber++);

            if (gameRules.isFinish()) {
                renderer.renderMap(playerManager.getPlayers());
                renderer.renderWinner(gameRules.getWinner());
                return;
            }

            playerManager.swapPlayers();
        }
    }
}
