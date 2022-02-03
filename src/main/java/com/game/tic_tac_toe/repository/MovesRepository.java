package com.game.tic_tac_toe.repository;

import com.game.tic_tac_toe.entity.Moves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovesRepository extends JpaRepository<Moves, Long> {

    @Query(value = "select m.field from moves m where m.game_id=:gameId order by m.create_dt DESC fetch first 1 rows only", nativeQuery = true)
    Optional<String> findLastFieldByGameId(Long gameId);
}
