package com.game.tic_tac_toe.service.games;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WinService {

    public char isCheckWin(String str, char xo) {
        char[] field = str.toCharArray();
        if (field[0] == field[1] && field[1] == field[2] && field[0] == xo) {
            return xo;
        }
        if (field[3] == field[4] && field[4] == field[5] && field[3] == xo) {
            return xo;
        }
        if (field[6] == field[7] && field[7] == field[8] && field[6] ==xo) {
            return xo;
        }
        if (field[0] == field[3] && field[3] == field[6] && field[0] == xo) {
            return xo;
        }
        if (field[1] == field[4] && field[4] == field[7] && field[1] ==xo) {
            return xo;
        }
        if (field[2] == field[5] && field[5] == field[8] && field[2] == xo) {
            return xo;
        }
        if (field[0] == field[4] && field[4] == field[8] && field[0] == xo) {
            return xo;
        }
        if (field[2] == field[4] && field[4] == field[6] && field[2] == xo) {
            return xo;
        }
        return '7';
    }
}
