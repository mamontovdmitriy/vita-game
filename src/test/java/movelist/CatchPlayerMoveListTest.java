package movelist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.relex.movelist.EscapePlayerMoveList;
import ru.relex.movelist.MoveList;

import java.util.List;

public class CatchPlayerMoveListTest {
    MoveList moveList;

    @Before
    public void init() {
        moveList = new EscapePlayerMoveList();
    }

    @Test
    public void listSizeIsEleven() {
        Assert.assertEquals(11, moveList.getMoveList().size());
    }

    @Test
    public void moveListShouldBeFill() {
        for (List<Integer> list : moveList.getMoveList()) {
            Assert.assertNotNull(list);
        }
    }
}
