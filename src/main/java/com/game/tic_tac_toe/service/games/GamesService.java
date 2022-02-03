package com.game.tic_tac_toe.service.games;

import com.game.tic_tac_toe.entity.Games;

public interface GamesService {

    Games createGames(Long idPlayer);

    String moveGames(Long idGame, int pos);
}
