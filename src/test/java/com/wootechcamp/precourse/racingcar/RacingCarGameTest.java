package com.wootechcamp.precourse.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    @Test
    @DisplayName("5자리 이하의 글자 검사, input 0")
    public void isUnderFiveSpellingsTest0(){
        try {
            RacingCarGame racingCarGame = new RacingCarGame();

            Method method = racingCarGame.getClass().getDeclaredMethod("isOneDigit", int.class);
            method.setAccessible(true);

            boolean isUnderFiveSpellings = (boolean) method.invoke(racingCarGame, 0);
           assertThat(true).isEqualTo(isUnderFiveSpellings);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Test
    @DisplayName("5자리 이하의 글자 검사, input 6")
    public void isUnderFiveSpellingsTest6(){
        try {
            RacingCarGame racingCarGame = new RacingCarGame();

            Method method = racingCarGame.getClass().getDeclaredMethod("isOneDigit", int.class);
            method.setAccessible(true);

            boolean isUnderFiveSpellings = (boolean) method.invoke(racingCarGame, 6);
            assertThat(true).isEqualTo(isUnderFiveSpellings);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Test
    @DisplayName("5자리 이하의 글자 검사, input 10")
    public void isUnderFiveSpellingsTest10(){
        try {
            RacingCarGame racingCarGame = new RacingCarGame();

            Method method = racingCarGame.getClass().getDeclaredMethod("isOneDigit", int.class);
            method.setAccessible(true);

            boolean isUnderFiveSpellings = (boolean) method.invoke(racingCarGame, 10);
            assertThat(false).isEqualTo(isUnderFiveSpellings);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Test
    @DisplayName("5자리 이하의 글자 검사, input 11")
    public void isUnderFiveSpellingsTest11(){
        try {
            RacingCarGame racingCarGame = new RacingCarGame();

            Method method = racingCarGame.getClass().getDeclaredMethod("isOneDigit", int.class);
            method.setAccessible(true);

            boolean isUnderFiveSpellings = (boolean) method.invoke(racingCarGame, 11);
            assertThat(false).isEqualTo(isUnderFiveSpellings);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
