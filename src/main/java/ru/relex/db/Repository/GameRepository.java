package ru.relex.db.Repository;

import org.springframework.data.repository.CrudRepository;
import ru.relex.db.Entity.Game;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Integer> {
    List<Game> findByOrderByCreatedAtAsc();
}
