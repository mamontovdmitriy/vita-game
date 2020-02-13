package ru.relex.console;

import ru.relex.player.Player;

import java.util.List;

/**
 * Класс для отображения на экран (результатов и отрисовки карты)
 */
public class ConsoleRenderer {
    final String EOL = "\n";
    final String template =
            "    [0]" + EOL +
            "[1] [2] [3]" + EOL +
            "[4] [5] [6]" + EOL +
            "[7] [8] [9]" + EOL +
            "    [10]" + EOL;

    /**
     * Отрисовка карты с фигурами игроков
     * @param playerList список игроков
     */
    public void renderMap(List<Player> playerList) {
        String battleField = template;

        for (Player player : playerList) {
            for (int position : player.getPositions()) {
                String pattern = String.format("[%d]", position);
                String newValue = String.format("[%s]", player.getIcon());

                battleField = battleField.replace(pattern, newValue);
            }
        }

        System.out.print(battleField);
    }

    /**
     * @todo в разработке
     */
    public void renderRules() {
    }

    /**
     * Вывод победителя
     * @param winner победитель
     */
    public void renderWinner(Player winner) {
        if (winner != null) {
            System.out.printf("Congrats! Win of %s.", winner.getName());
        } else {
            System.out.print("No winners.");
        }
    }
}
