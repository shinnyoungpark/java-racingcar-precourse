package com.wootechcamp.precourse.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @Test
    @DisplayName("랜덤 번호 생성 테스트")
    public void getRandomNumberTest(){
        //given
        //when
        int result = RandomNumberGenerator.getRandomNumber();

        //then
        Set<Integer> resultSet = new HashSet<>();
        for(int i = 0; i < 10; i++)
            resultSet.add(i);

        assertThat(resultSet.contains(result)).isTrue();
    }

}
