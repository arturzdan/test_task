package com.game.tic_tac_toe.service.validation.game;

import com.game.tic_tac_toe.repository.GamesRepository;
import com.game.tic_tac_toe.repository.PlayersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.game.tic_tac_toe.consts.MassageConst.NO_FOUND_GAME;

@Service
@Slf4j
@AllArgsConstructor
public class GamesValidationImpl implements GamesValidation {

    @Autowired
    private PlayersRepository playersRepository;

    @Autowired
    private GamesRepository gamesRepository;

    public boolean validateCreateGame(Long playerId) {
        return !playersRepository.existsById(playerId);
    }

    @Override
    public String validateMoveGame(Long gameId, int pos) {
        if (pos < 0 || pos > 8) {
            return "invalid range pos:\n%s \nenter a number from 0 to 8";
        }
        if (!gamesRepository.existsById(gameId)) {
            return String.format(NO_FOUND_GAME, gameId);
        }
        return "";
    }


}