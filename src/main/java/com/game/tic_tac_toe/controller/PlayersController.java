package com.game.tic_tac_toe.controller;

import com.game.tic_tac_toe.entity.Players;
import com.game.tic_tac_toe.service.players.PlayersService;
import com.game.tic_tac_toe.service.validation.player.PlayersValidation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.game.tic_tac_toe.consts.MassageConst.*;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/user")
public class PlayersController {

    private final PlayersValidation playersValidation;
    private final PlayersService playersService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(String name, int pass) {
        if (playersValidation.validateNameUser(name)) {
            return createResponseAndLog(CREATE_USER_ERROR, name);
        }

        Players players = playersService.add(name, pass);

        return createResponseAndLog(CREATE_USER, players.toString());
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public String find(String name) {
        try {
            Players players = playersService.find(name);
            return createResponseAndLog(FOUND_PLAYER, players.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return createResponseAndLog(NO_FOUND_PLAYER, name);
    }

    private String createResponseAndLog(String message, String str) {
        String format = String.format(message, str);
        log.info(format);
        return format;
    }
}