package ru.relex.movelist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Карта возможных перемещений для EscapePlayer
 */
public class EscapePlayerMoveList implements MoveList {
    private List<List<Integer>> moveList = new ArrayList<>(SIZE);

    public EscapePlayerMoveList() {
        this.moveList.add(0, Arrays.asList(1, 2, 3));
        this.moveList.add(1, Arrays.asList(2, 4)); //0, вниз можно, вверх нельзя
        this.moveList.add(2, Arrays.asList(0, 1, 3, 5));
        this.moveList.add(3, Arrays.asList(2, 6)); //0, вниз можно, вверх нельзя
        this.moveList.add(4, Arrays.asList(1, 5, 7));
        this.moveList.add(5, Arrays.asList(2, 4, 6, 8));
        this.moveList.add(6, Arrays.asList(3, 5, 9));
        this.moveList.add(7, Arrays.asList(4, 8)); //10 нельзя
        this.moveList.add(8, Arrays.asList(5, 7, 9, 10));
        this.moveList.add(9, Arrays.asList(6, 8)); //10 нельзя
        this.moveList.add(10, Collections.singletonList(8));
    }

    @Override
    public List<List<Integer>> getMoveList() {
        return this.moveList;
    }

    @Override
    public List<Integer> getMoves(int index) {
        return moveList.get(index);
    }
}
