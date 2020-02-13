package player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.relex.player.Player;

import java.util.Arrays;

public class CatchPlayerTest {
    Player player;

    @Before
    public void init() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        player = context.getBean("catchPlayer", Player.class);
    }

    @Test
    public void nameShouldBePlayer1() {
        Assert.assertEquals("Player 1", player.getName());
    }

    @Test
    public void iconShouldBeX() {
        Assert.assertEquals("X", player.getIcon());
    }

    @Test
    public void movesShouldBeFill() {
        Assert.assertNotNull(player.getMoveList());
    }

    @Test
    public void positionsShouldBeSet() {
        Assert.assertEquals(Arrays.asList(7, 9, 10), player.getPositions());
    }
}
