package com.game.tic_tac_toe.repository;

import com.game.tic_tac_toe.entity.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface GamesRepository extends JpaRepository<Games, Long> {

    Optional<Games> findByGameId(Long gameId);

    @Query(value = "UPDATE games SET status=?status WHERE game_id=?gameId", nativeQuery = true)
    void updateStatusByGameId(Long gameId, String status);
}
