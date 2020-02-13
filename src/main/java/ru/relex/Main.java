package ru.relex;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.relex.game.Game;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        Game game = context.getBean(Game.class);

        game.start();
    }
}
