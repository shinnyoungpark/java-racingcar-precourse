package com.wootechcamp.precourse.racingcar;

import com.wootechcamp.precourse.racingcar.util.StringArrayChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringArrayCheckerTest {
    private static final int CAR_NAME_MAX_LENGTH = 5;

    @Test
    @DisplayName("5자리 이하의 글자 검사, true")
    public void isUnderMaxSpellingsTrueTest(){
        //given
        String[] input = new String[] {"abcde","ghlm"};

        //when
        boolean result = StringArrayChecker.isUnderMaxSpellings(input, CAR_NAME_MAX_LENGTH);

        //then
        assertThat(true).isEqualTo(result);

    }

    @Test
    @DisplayName("5자리 이하의 글자 검사, false")
    public void isUnderMaxSpellingsFalseTest(){
            //given
            String[] input = new String[] {"abcdef","ghlm"};

            //when
            boolean result = StringArrayChecker.isUnderMaxSpellings(input, CAR_NAME_MAX_LENGTH);

            //then
            assertThat(false).isEqualTo(result);

    }

    @Test
    @DisplayName("중복이름 삭제 테스트")
    public void removeDuplicateNameTest(){
        //given
        String[] input = new String[] {"ghlm","abcdef","ghlm"};

        //when
        String[] result = StringArrayChecker.removeDuplicateName(input);

        //then
        List<String> thenResult = new ArrayList<>();
        thenResult.add("ghlm");
        thenResult.add("abcdef");
        assertThat(thenResult.containsAll(Arrays.asList(result))).isTrue();

    }

    @Test
    @DisplayName("빈 이름 삭제 테스트")
    public void removeEmptyStringTest(){
        //given
        String[] input = new String[] {"ghlm","","abcdef"};

        //when
        String[] result = StringArrayChecker.removeEmptyString(input);

        //then
        List<String> thenResult = new ArrayList<>();
        thenResult.add("ghlm");
        thenResult.add("abcdef");
        assertThat(thenResult.containsAll(Arrays.asList(result))).isTrue();
    }
}
