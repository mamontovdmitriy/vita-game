package ru.relex.db.Repository;

import org.springframework.data.repository.CrudRepository;
import ru.relex.db.Entity.Game;
import ru.relex.db.Entity.Move;

import java.util.List;

public interface MoveRepository extends CrudRepository<Move, Long> {
    List<Move> findByGameOrderByCreatedAtAsc(Game game);
}
