package com.game.tic_tac_toe.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeStones {

    X('x'),
    O('o');

    private char stones;
}
