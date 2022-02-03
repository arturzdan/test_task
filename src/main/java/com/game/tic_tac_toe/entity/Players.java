package com.game.tic_tac_toe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@Entity
@Table(name = "players")
public class Players implements Serializable {

    /**
     * Id игрока
     */
    @Id
    @Column(name = "player_id", nullable = false, updatable = false)
    private Long playerId;

    /**
     * Имя игрока
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Хеш пароля
     */
    @Column(name = "pass", nullable = false)
    private Integer pass;
    /**
     * Тип игрока:
     * true -  человек
     * false - компьютер
     */
    @Column(name = "real_player")
    private boolean realPlayer;
}
