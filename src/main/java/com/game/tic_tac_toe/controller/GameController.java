package com.game.tic_tac_toe.controller;

import com.game.tic_tac_toe.entity.Games;
import com.game.tic_tac_toe.service.games.GamesService;
import com.game.tic_tac_toe.service.validation.game.GamesValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.game.tic_tac_toe.consts.MassageConst.CREATE_GAME;
import static com.game.tic_tac_toe.consts.MassageConst.CREATE_GAME_ERROR;

@RestController
@Slf4j
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GamesService gamesService;

    @Autowired
    private GamesValidation gamesValidation;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Long playerId) {
        if (gamesValidation.validateCreateGame(playerId)) {
            return createResponseAndLog(CREATE_GAME_ERROR, playerId.toString());
        }

        Games games = gamesService.createGames(playerId);

        return createResponseAndLog(CREATE_GAME, games.toString());
    }

    @RequestMapping(value = "/move", method = RequestMethod.POST)
    public String move(Long gameId, int pos) {
        String validate = gamesValidation.validateMoveGame(gameId, pos);
        if (!validate.isBlank()) {
            return validate;
        }
        return gamesService.moveGames(gameId, pos);
    }

    private String createResponseAndLog(String message, String str) {
        String format = String.format(message, str);
        log.info(format);
        return format;
    }
}

