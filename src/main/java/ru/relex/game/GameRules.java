package ru.relex.game;

import ru.relex.player.Player;
import ru.relex.player.PlayerManager;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Копмонент правил игры содержит проверки игровых ограничений
 */
public class GameRules {
    PlayerManager playerManager;
    Player winner;

    /**
     * @param playerManager компонент управления игроками
     */
    public GameRules(PlayerManager playerManager) {
        this.playerManager = playerManager;
        this.winner = null;
    }

    /**
     * Восстановление первоначального состояния
     */
    public void init() {
        playerManager.init();
        winner = null;
    }

    /**
     * @return компонент управления игроками
     */
    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    /**
     * @return победитель игры
     */
    public Player getWinner() {
        return winner;
    }

    /**
     * @return доступные ходы игрока на текущем шаге
     */
    public Collection<String> getAvailableMoves(Player player) {
        Collection<String> availableMoves = new HashSet<>();
        Collection<String> unavailableMoves = new HashSet<>();

        // формируем множества доступных ходов и заблокированных ходов
        for (Integer position : player.getPositions()) {
            unavailableMoves.add(String.valueOf(position));

            availableMoves.addAll(player.getMoveList().getMoves(position)
                    .stream()
                    .map(Object::toString)
                    .collect(Collectors.toList())
            );
        }

        // дополняем заблокированные ходы противником
        Player otherPlayer = playerManager.getOtherPlayer(player);
        for (Integer position : otherPlayer.getPositions()) {
            unavailableMoves.add(String.valueOf(position));
        }

        // убираем заблокированные
        availableMoves.removeAll(unavailableMoves);

        return availableMoves;
    }

    /**
     * Закончена ли игра
     */
    public boolean isFinish() {
        if (isPlayerCaught()) {
            winner = playerManager.getCatchPlayer();
            return true;
        }

        if (isPlayerEscaped()) {
            winner = playerManager.getEscapePlayer();
            return true;
        }

        return isNoWin();
    }

    /**
     * Ничья - догоняющий не может совершить свой ход
     * @return ничья
     */
    protected boolean isNoWin() {
        return getAvailableMoves(playerManager.getCatchPlayer()).isEmpty();
    }

    /**
     * Игрок пойтан - убегающий не может совершить свой ход
     * @return победа 1 игрока
     */
    protected boolean isPlayerCaught() {
        return getAvailableMoves(playerManager.getEscapePlayer()).isEmpty();
    }

    /**
     * Игрок сбежал - убегающий "ниже" всех фигур догоняющего
     * @return победа 2 игрока
     */
    protected boolean isPlayerEscaped() {
        int catchPlayerDistance = calculateDistance(playerManager.getCatchPlayer());
        int escapePlayerDistance = calculateDistance(playerManager.getEscapePlayer());

        return catchPlayerDistance < escapePlayerDistance;
    }

    /**
     * Условное расстояние от "начала координат" до "последней фигуры игрока".
     * Метрика используется для определения победы 2 игрока
     * @param player игрок
     * @return удаленность
     */
    protected int calculateDistance(Player player) {
        int position = Collections.max(player.getPositions());
        int distance = 0;

        while (position != 0) {
            distance++;
            List<Integer> availablePosition = player.getMoveList().getMoves(position);
            position = Collections.min(availablePosition);
        }

        return distance;
    }
}
