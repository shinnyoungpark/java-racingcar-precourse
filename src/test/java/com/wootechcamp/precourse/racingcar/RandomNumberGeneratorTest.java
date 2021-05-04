package com.wootechcamp.precourse.racingcar;

import com.wootechcamp.precourse.racingcar.util.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @Test
    @DisplayName("")
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
