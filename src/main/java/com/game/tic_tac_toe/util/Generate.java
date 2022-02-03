package com.game.tic_tac_toe.util;

import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor
public class Generate {
    public static Long randomLong() {
        return Math.abs(new Random().nextLong());
    }
}