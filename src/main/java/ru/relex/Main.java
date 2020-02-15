package ru.relex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import ru.relex.menu.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ImportResource(value = "classpath:context.xml")
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("1", "New game", context.getBean(NewGameCommand.class)));
        menuItems.add(new MenuItem("2", "Load game", context.getBean(LoadGameCommand.class)));
        menuItems.add(new MenuItem("3", "Exit", context.getBean(ExitCommand.class)));

        new MainMenu(menuItems).show();
    }
}
