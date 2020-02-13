package ru.relex.player;

import java.util.Arrays;
import java.util.List;

/**
 * Класс управления игроками
 */
public class PlayerManager {
    private Player catchPlayer;
    private Player escapePlayer;
    private List<Player> players;
    private Player activePlayer;

    /**
     * @param catchPlayer Игрок догоняющий
     * @param escapePlayer Игрок убегающий
     */
    public PlayerManager(Player catchPlayer, Player escapePlayer) {
        this.catchPlayer = catchPlayer;
        this.escapePlayer = escapePlayer;
        this.players = Arrays.asList(catchPlayer, escapePlayer);
        this.activePlayer = catchPlayer;
    }

    /**
     * @return Догоняющий игрок
     */
    public Player getCatchPlayer() {
        return catchPlayer;
    }

    /**
     * @return Убегающий игрок
     */
    public Player getEscapePlayer() {
        return escapePlayer;
    }

    /**
     * @return Список игроков
     */
    public List<Player> getPlayers() {
        return this.players;
    }

    /**
     * @return Активный игрок, который сейчас ходит
     */
    public Player getActivePlayer() {
        return this.activePlayer;
    }

    /**
     * @param player Игрок
     * @return Другой игрок
     */
    public Player getOtherPlayer(Player player) {
        if (player.equals(this.catchPlayer)) {
            return this.escapePlayer;
        }

        return this.catchPlayer;
    }

    /**
     * Передача хода другому игроку
     */
    public void swapPlayers() {
        this.activePlayer = getOtherPlayer(this.activePlayer);
    }
}
