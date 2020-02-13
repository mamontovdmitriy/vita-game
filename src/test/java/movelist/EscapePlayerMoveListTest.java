package movelist;

import org.junit.Assert;
import org.junit.Test;
import ru.relex.movelist.CatchPlayerMoveList;
import ru.relex.movelist.EscapePlayerMoveList;
import ru.relex.movelist.MoveList;

import java.util.List;

public class EscapePlayerMoveListTest {
    @Test
    public void sizeOfCatchPlayerMoveListIsEleven() {
        MoveList moveList = new CatchPlayerMoveList();

        Assert.assertEquals(11, moveList.getMoveList().size());
    }

    @Test
    public void CatchPlayerMoveListShouldBeFill() {
        MoveList moveList = new CatchPlayerMoveList();

        for (List<Integer> list : moveList.getMoveList()) {
            Assert.assertNotNull(list);
        }
    }

    @Test
    public void sizeOfEscapePlayerMoveListIsEleven() {
        MoveList moveList = new EscapePlayerMoveList();

        Assert.assertEquals(11, moveList.getMoveList().size());
    }

    @Test
    public void EscapePlayerMoveListShouldBeFill() {
        MoveList moveList = new EscapePlayerMoveList();

        for (List<Integer> list : moveList.getMoveList()) {
            Assert.assertNotNull(list);
        }
    }
}
