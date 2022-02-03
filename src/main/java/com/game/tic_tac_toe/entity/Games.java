package com.game.tic_tac_toe.entity;

import com.game.tic_tac_toe.consts.StatusGames;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@Entity
@Table(name = "games")
public class Games {

    /**
     * Id игры
     */
    @Id
    @Column(name = "game_id")
    private Long gameId;

    /**
     * Id первого игрока
     */
    @Column(name = "player_one_id")
    private Long playerOneId;

    /**
     * Id второго игрока
     */
    @Column(name = "player_too_id")
    private Long playerTooId;

    /**
     * Статус игры
     */
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusGames status;

    /**
     * Id победителя игры
     */
    @Column(name = "winner_player_id")
    private String winnerPlayerId;
}
