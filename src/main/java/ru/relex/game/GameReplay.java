package ru.relex.game;

import ru.relex.console.ConsoleInput;
import ru.relex.console.ConsoleRenderer;
import ru.relex.db.Entity.Game;
import ru.relex.db.Entity.Move;
import ru.relex.player.Player;
import ru.relex.player.PlayerManager;

import java.util.Collections;

public class GameReplay {
    private ConsoleRenderer renderer;
    private GameRules gameRules;

    /**
     * @param rules           правила игры
     * @param consoleRenderer вывод на экран
     */
    public GameReplay(GameRules rules, ConsoleRenderer consoleRenderer) {
        this.gameRules = rules;
        this.renderer = consoleRenderer;
    }

    /**
     * @param game игра, которую нужно воспроизвести
     */
    public void replay(Game game) {
        gameRules.init();
        PlayerManager playerManager = gameRules.getPlayerManager();

        for (Move move : game.getMoves()) {
            Player player = playerManager.getActivePlayer();
            player.move(move.getPosition());

            System.out.printf(
                    "\n#%d. %s[%s] has moved on position [%d]\n",
                    move.getNumber(),
                    player.getName(),
                    player.getIcon(),
                    move.getPosition()
            );

            renderer.renderMap(playerManager.getPlayers());

            playerManager.swapPlayers();
        }

        if (gameRules.isFinish()) {
            renderer.renderWinner(gameRules.getWinner());
        } else {
            ConsoleInput.getCommand("Press ENTER to return to menu", Collections.emptyList());
        }
    }
}
