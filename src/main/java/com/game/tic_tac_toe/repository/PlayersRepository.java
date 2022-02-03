package com.game.tic_tac_toe.repository;

import com.game.tic_tac_toe.entity.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayersRepository extends JpaRepository<Players, Long> {

    Optional<Players> findByName(String name);
}
