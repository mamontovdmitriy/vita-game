package player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.relex.movelist.CatchPlayerMoveList;
import ru.relex.movelist.MoveList;
import ru.relex.player.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerTest {
    MoveList moveList = new CatchPlayerMoveList();
    List<Integer> positions = new ArrayList<>(3);
    String icon = "Icon";
    String name = "Name";

    Player player;

    @Before
    public void init() {
        player = new Player(moveList, positions, icon, name);
    }

    @Test
    public void checkGetMoveList() {
        Assert.assertEquals(moveList, player.getMoveList());
    }

    @Test
    public void checkGetPositions() {
        Assert.assertEquals(positions, player.getPositions());
    }

    @Test
    public void checkGetIcon() {
        Assert.assertEquals(icon, player.getIcon());
    }

    @Test
    public void checkGetName() {
        Assert.assertEquals(name, player.getName());
    }
}
