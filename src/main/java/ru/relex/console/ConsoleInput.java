package ru.relex.console;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;

/**
 * Класс для взаимодействия с пользователем через консоль
 */
public class ConsoleInput {
    /**
     * Получение команды от пользователя
     *
     * @param message         текст сообщения, поясняющий ввод
     * @param allowedCommands допустимые команды
     * @return строковое представление введенной пользоветелем команды
     */
    public static String getCommand(String message, Collection<String> allowedCommands) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print(message);
            if (!allowedCommands.isEmpty()) {
                System.out.print(allowedCommands);
                System.out.print(": ");
            }

            try {
                String line = br.readLine();

                if (!allowedCommands.isEmpty() && !allowedCommands.contains(line)) {
                    throw new Exception("Unknown command!");
                }

                return line;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
