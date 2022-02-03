package com.game.tic_tac_toe.service.players;

import com.game.tic_tac_toe.entity.Players;

public interface PlayersService {

    Players add(String name, int pass);

    Players find(String name) throws Exception;
}
