package ru.relex.db;

import ru.relex.db.Entity.Game;
import ru.relex.db.Entity.Move;
import ru.relex.db.Repository.GameRepository;
import ru.relex.db.Repository.MoveRepository;
import ru.relex.player.Player;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameStore {
    private GameRepository gameRepository;
    private MoveRepository moveRepository;

    public GameStore(GameRepository gameRepository, MoveRepository moveRepository) {
        this.gameRepository = gameRepository;
        this.moveRepository = moveRepository;
    }

    public Game createSavedGame() {
        Game game = new Game();

        game.setCreatedAt(new Timestamp(new Date().getTime()));

        return gameRepository.save(game);
    }

    public void saveMove(Game game, Player player, int position, int number) {
        Move move = new Move();

        move.setGame(game);
        move.setPlayer(getPlayerNumber(player));
        move.setPosition(position);
        move.setNumber(number);
        move.setCreatedAt(new Timestamp(new Date().getTime()));

        moveRepository.save(move);
    }

    public List<Game> listSavedGames() {
        return gameRepository.findByOrderByCreatedAtAsc();
    }

    public List<Move> listMoves(Game game) {
        return moveRepository.findByGameOrderByCreatedAtAsc(game);
    }

    private int getPlayerNumber(Player player) {
        Pattern patternNumber = Pattern.compile("(\\d+)");
        Matcher matcher = patternNumber.matcher(player.getName());

        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }

        return 0;
    }
}
