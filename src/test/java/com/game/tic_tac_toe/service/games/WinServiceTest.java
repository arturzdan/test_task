package com.game.tic_tac_toe.service.games;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class WinServiceTest {

    @Autowired
    private WinService winService;

    @Test
    void checkNoWin() {
        char x = winService.isCheckWin("---------", 'x');
        Assertions.assertEquals(x, '7');
    }

    @Test
    void checkWin() {
        List<String> games = Arrays.asList(
                "xxx------",
                "---xxx---",
                "------xxx",
                "x--x--x--",
                "-x--x--x-",
                "--x--x--x",
                "x---x---x",
                "--x-x-x--"
        );
        games.forEach(this::gamesCheckWin);
    }


    private void gamesCheckWin(String str) {
        char x = winService.isCheckWin(str, 'x');
        char o = winService.isCheckWin(str, 'o');
        Assertions.assertEquals(x, 'x');
        Assertions.assertEquals(o, '7');
    }
}