package ru.relex.player;

import ru.relex.movelist.MoveList;

import java.util.Collection;
import java.util.List;

/**
 * Класс Игрок
 */
public class Player {
    private String icon;
    private String name;

    /**
     * Позиции фигур игрока
     */
    private List<Integer> positions;
    /**
     * Возможные ходы игрока
     */
    private MoveList moveList;

    /**
     * @param moveList карта возможныхы перемещений игрока по всему полю
     * @param positions начальное положение игрока на поле
     * @param icon символ для отображения на карте
     * @param name имя игрока
     */
    public Player(MoveList moveList, List<Integer> positions, String icon, String name) {
        this.moveList = moveList;
        this.positions = positions;
        this.icon = icon;
        this.name = name;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public Collection<Integer> getPositions() {
        return this.positions;
    }

    public MoveList getMoveList() {
        return this.moveList;
    }

    /**
     * Перемещение фигуры игрока на новую позицию
     * @param index новая позиция игрока
     */
    public void move(Integer index) {
        for (int i = 0; i < this.positions.size(); i++) {
            Integer position = this.positions.get(i);
            if (this.moveList.getMoves(position).contains(index)) {
                this.positions.set(i, index);
                break;
            }
        }
    }

    /**
     * Нужен только для тестов
     */
    public void setPositions(List<Integer> positions) {
        this.positions = positions;
    }
}
