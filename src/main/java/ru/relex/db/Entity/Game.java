package ru.relex.db.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "games")
public class Game {
    @Id
    @GeneratedValue(generator="sqlite")
    @TableGenerator(name="sqlite", table="sqlite_sequence",
            pkColumnName="name", valueColumnName="seq",
            pkColumnValue="sqliteGamesTable")
    private Integer id;

    private Timestamp createdAt;

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

    @Override
    public String toString() {
        return String.format("Game {id:%s, createdAt:%s}", id, createdAt);
    }
}
