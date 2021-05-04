package com.wootechcamp.precourse.racingcar.util;

import java.util.Random;

public class RandomNumberGenerator {
    public static int getRandomNumber(){
        Random random = new Random();
        return random.nextInt(10);
    }
}
