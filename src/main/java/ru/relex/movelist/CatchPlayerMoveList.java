package ru.relex.movelist;

import java.util.*;

/**
 * Карта возможных перемещений для CatchPlayer
 */
public class CatchPlayerMoveList implements MoveList {
    private List<List<Integer>> moveList = new ArrayList<>(SIZE);

    public CatchPlayerMoveList() {
        this.moveList.add(0, Collections.emptyList());
        this.moveList.add(1, Collections.singletonList(0));
        this.moveList.add(2, Collections.singletonList(0));
        this.moveList.add(3, Collections.singletonList(0));
        this.moveList.add(4, Collections.singletonList(1));
        this.moveList.add(5, Collections.singletonList(2));
        this.moveList.add(6, Collections.singletonList(3));
        this.moveList.add(7, Collections.singletonList(4));
        this.moveList.add(8, Collections.singletonList(5));
        this.moveList.add(9, Collections.singletonList(6));
        this.moveList.add(10, Collections.singletonList(8));
    }

    @Override
    public List<List<Integer>> getMoveList() {
        return this.moveList;
    }

    @Override
    public List<Integer> getMoves(int index) {
        return this.moveList.get(index);
    }
}
