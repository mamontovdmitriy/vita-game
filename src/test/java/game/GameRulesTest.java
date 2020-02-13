package game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.relex.game.GameRules;
import ru.relex.movelist.CatchPlayerMoveList;
import ru.relex.movelist.EscapePlayerMoveList;
import ru.relex.movelist.MoveList;
import ru.relex.player.Player;
import ru.relex.player.PlayerManager;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameRulesTest {
    MoveList catchPlayerMoveList = new CatchPlayerMoveList();
    MoveList escapePlayerMoveList = new EscapePlayerMoveList();
    List<Integer> catchPlayerPositions = Arrays.asList(7, 9, 10);
    List<Integer> escapePlayerPositions = Collections.singletonList(5);
    Player catchPlayer;
    Player escapePlayer;
    PlayerManager playerManager;
    GameRules gameRules;

    @Before
    public void init() {
        catchPlayer = new Player(catchPlayerMoveList, catchPlayerPositions, "X", "Player 1");
        escapePlayer = new Player(escapePlayerMoveList, escapePlayerPositions, "*", "Player 2");
        playerManager = new PlayerManager(catchPlayer, escapePlayer);

        gameRules = new GameRules(playerManager);
    }

    @Test
    public void checkGetPlayerManager() {
        Assert.assertEquals(playerManager, gameRules.getPlayerManager());
    }

    @Test
    public void winnerShouldBeEmpty() {
        Assert.assertNull(gameRules.getWinner());
    }

    @Test
    public void checkGetAvailableMovesForPlayer1() {
        Set<String> expected = Stream.of("4", "6", "8").collect(Collectors.toSet());
        Set<String> actual = new HashSet<>(gameRules.getAvailableMoves(catchPlayer));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkGetAvailableMovesForPlayer2() {
        Set<String> expected = Stream.of("2", "4", "6", "8").collect(Collectors.toSet());
        Set<String> actual = new HashSet<>(gameRules.getAvailableMoves(escapePlayer));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isFinishShouldBeFalseByDefault() {
        Assert.assertFalse(gameRules.isFinish());
    }

    @Test
    public void checkIsNoWin() {
        gameRules.getPlayerManager().getEscapePlayer().setPositions(Collections.singletonList(8));
        gameRules.getPlayerManager().getCatchPlayer().setPositions(Arrays.asList(0, 10, 3));

        Assert.assertTrue(gameRules.isFinish());
    }

    @Test
    public void checkWinCatchPlayer() {
        PlayerManager playerManager = gameRules.getPlayerManager();
        playerManager.getEscapePlayer().setPositions(Collections.singletonList(0));
        playerManager.getCatchPlayer().setPositions(Arrays.asList(1, 2, 3));

        Assert.assertTrue(gameRules.isFinish());
        Assert.assertEquals(playerManager.getCatchPlayer(), gameRules.getWinner());
    }

    @Test
    public void checkWinEscapePlayer() {
        PlayerManager playerManager = gameRules.getPlayerManager();
        playerManager.getEscapePlayer().setPositions(Collections.singletonList(7));
        playerManager.getCatchPlayer().setPositions(Arrays.asList(1, 5, 3));

        Assert.assertTrue(gameRules.isFinish());
        Assert.assertEquals(playerManager.getEscapePlayer(), gameRules.getWinner());
    }
}
