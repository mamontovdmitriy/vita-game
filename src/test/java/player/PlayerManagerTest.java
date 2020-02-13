package player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.relex.movelist.CatchPlayerMoveList;
import ru.relex.movelist.MoveList;
import ru.relex.player.Player;
import ru.relex.player.PlayerManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerManagerTest {
    MoveList moveList = new CatchPlayerMoveList();
    List<Integer> positions = new ArrayList<>(3);
    Player catchPlayer;
    Player escapePlayer;
    PlayerManager playerManager;

    @Before
    public void init() {
        catchPlayer = new Player(moveList, positions, "X", "Player 1");
        escapePlayer = new Player(moveList, positions, "*", "Player 2");

        playerManager = new PlayerManager(catchPlayer, escapePlayer);
    }

    @Test
    public void checkGetCatchPlayer() {
        Assert.assertEquals(catchPlayer, playerManager.getCatchPlayer());
    }

    @Test
    public void checkGetEscapePlayer() {
        Assert.assertEquals(escapePlayer, playerManager.getEscapePlayer());
    }

    @Test
    public void checkGetPlayerList() {
        Assert.assertEquals(Arrays.asList(catchPlayer, escapePlayer), playerManager.getPlayers());
    }

    @Test
    public void checkGetActivePlayer() {
        Assert.assertEquals(catchPlayer, playerManager.getActivePlayer());
    }

    @Test
    public void checkSwapPlayer() {
        playerManager.swapPlayers();

        Assert.assertEquals(escapePlayer, playerManager.getActivePlayer());
    }
}
