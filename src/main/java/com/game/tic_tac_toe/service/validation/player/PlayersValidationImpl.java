package com.game.tic_tac_toe.service.validation.player;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@AllArgsConstructor
public class PlayersValidationImpl implements PlayersValidation {

    public boolean validateNameUser(String name) {
        return Objects.requireNonNull(name).isBlank() || name.length() > 50;
    }
}
