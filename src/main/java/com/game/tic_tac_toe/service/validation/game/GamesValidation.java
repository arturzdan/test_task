package com.game.tic_tac_toe.service.validation.game;

public interface GamesValidation {

    boolean validateCreateGame(Long playerId);

    String validateMoveGame(Long gameId, int pos);
}
