package player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.relex.player.Player;

import java.util.Collections;

public class EscapePlayerTest {
    Player player;

    @Before
    public void init() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        player = context.getBean("escapePlayer", Player.class);
    }

    @Test
    public void nameShouldBePlayer2() {
        Assert.assertEquals("Player 2", player.getName());
    }

    @Test
    public void iconShouldBeStar() {
        Assert.assertEquals("*", player.getIcon());
    }

    @Test
    public void movesShouldBeFill() {
        Assert.assertNotNull(player.getMoveList());
    }

    @Test
    public void positionsShouldBeSet() {
        Assert.assertEquals(Collections.singletonList(5), player.getPositions());
    }
}
