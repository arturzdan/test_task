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
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@Entity
@Table(name = "moves")
public class Moves {

    /**
     * Id moves
     */
    @Id
    @Column(name = "move_id")
    private Long moveId;

    /**
     * Id игры
     */
    @Column(name = "game_id")
    private Long gameId;

    /**
     * Поле игры
     */
    @Column(name = "field")
    private String field;

    /**
     * Дата создания записи
     */
    @Column(name = "create_dt")
    private LocalDateTime createDt;

}
