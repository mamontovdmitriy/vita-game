package ru.relex.movelist;

import java.util.List;

public interface MoveList {
    int SIZE = 11;

    List<Integer> getMoves(int index);

    List<List<Integer>> getMoveList();
}
