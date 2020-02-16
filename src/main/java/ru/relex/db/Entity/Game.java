package ru.relex.db.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.LinkedList;

@Entity(name = "games")
public class Game {
    @Id
    @GeneratedValue(generator = "sqlite")
    @TableGenerator(name = "sqlite", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue = "sqliteGamesTable")
    private Integer id;

    private Timestamp createdAt;

    @OneToMany(targetEntity = Move.class, mappedBy = "game", fetch = FetchType.EAGER)
    private Collection<Move> moves = new LinkedList<>();

    public Game() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Collection<Move> getMoves() {
        return moves;
    }

    public void setMoves(Collection<Move> moves) {
        this.moves = moves;
    }

    @Override
    public String toString() {
        return String.format("Game {id:%s, createdAt:%s}", id, createdAt);
    }
}
