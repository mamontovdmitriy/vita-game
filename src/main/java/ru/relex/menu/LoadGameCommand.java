package ru.relex.menu;

import ru.relex.console.ConsoleInput;
import ru.relex.console.ConsoleRenderer;
import ru.relex.db.Entity.Game;
import ru.relex.db.Repository.GameRepository;
import ru.relex.game.GameReplay;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LoadGameCommand implements Command {
    final String CMD_GO_BACK = "0";

    private GameRepository gameRepository;
    private ConsoleRenderer consoleRenderer;
    private GameReplay gameReplay;

    public LoadGameCommand(GameRepository gameRepository, ConsoleRenderer consoleRenderer, GameReplay gameReplay) {
        this.gameRepository = gameRepository;
        this.consoleRenderer = consoleRenderer;
        this.gameReplay = gameReplay;
    }

    @Override
    public void start() {
        List<Game> games = gameRepository.findByOrderByCreatedAtAsc();

        consoleRenderer.renderGames(games);

        String alias = ConsoleInput.getCommand("Your choice", availableCommand(games));

        if (alias.equals(CMD_GO_BACK)) {
            return;
        }

        gameRepository
                .findById(Integer.parseInt(alias))
                .ifPresent(game -> gameReplay.replay(game));
    }

    /**
     * @param games список доступных игр
     * @return список команд для меню
     */
    private List<String> availableCommand(List<Game> games) {
        List<String> availableCommands = new ArrayList<>();

        availableCommands.add(CMD_GO_BACK);
        availableCommands.addAll(
                games.stream()
                        .map(Game::getId)
                        .map(String::valueOf)
                        .collect(Collectors.toList())
        );

        return availableCommands;
    }
}
