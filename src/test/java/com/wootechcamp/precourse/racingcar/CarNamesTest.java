package com.wootechcamp.precourse.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNamesTest {

    @Test
    @DisplayName("구분자 예외 테스트")
    public void delimiterExceptionTest() {
        //given
        String input = "a|b|c";

        //when
        try {
            CarNames carNames = new CarNames(input);

            //then
            List<String> result = new ArrayList<>();
            result.add("a");
            result.add("b");
            result.add("c");

            //then
            assertThat(Arrays.asList(carNames.getCarNames()).containsAll(result)).isTrue();

        } catch (IllegalArgumentException illegalArgumentException) {
            //then
            assertThat("자동차 구분자는 , 로 해주세요.").isEqualTo(illegalArgumentException.getMessage());
        }
    }

    @Test
    @DisplayName("구분자 정상 테스트")
    public void delimiterTest() {
        //given
        String input = "a,b,c";

        //when
        try {
            CarNames carNames = new CarNames(input);

            //then
            List<String> result = new ArrayList<>();
            result.add("a");
            result.add("b");
            result.add("c");

            //then
            assertThat(Arrays.asList(carNames.getCarNames()).containsAll(result)).isTrue();

        } catch (IllegalArgumentException illegalArgumentException) {
            //then
            assertThat("자동차 구분자는 , 로 해주세요.").isEqualTo(illegalArgumentException.getMessage());
        }
    }

    @Test
    @DisplayName("빈 값 지우기 테스트")
    public void removeEmptyStringTest() {
        //given
        String input = "a,b,,c";

        //when
        CarNames carNames = new CarNames(input);

        //then
        List<String> result = new ArrayList<>();
        result.add("a");
        result.add("b");
        result.add("c");

        //then
        assertThat(Arrays.asList(carNames.getCarNames()).containsAll(result)).isTrue();

    }

    @Test
    @DisplayName("중복 값 지우기 테스트")
    public void removeDuplicateNameTest() {
        //given
        String input = "a,b,c,a";

        //when
        CarNames carNames = new CarNames(input);

        //then
        List<String> result = new ArrayList<>();
        result.add("a");
        result.add("b");
        result.add("c");

        //then
        assertThat(Arrays.asList(carNames.getCarNames()).containsAll(result)).isTrue();

    }
}
