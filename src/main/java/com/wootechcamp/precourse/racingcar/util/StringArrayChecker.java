package com.wootechcamp.precourse.racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class StringArrayChecker {

    public static String[] removeEmptyString(String[] carNames) {
        List<String> result = new ArrayList<>();

        for(int i = 0; i < carNames.length; i++){
            if(carNames[i] != null && carNames[i].length() > 0){
                result.add(carNames[i]);
            }
        }

        return result.toArray(new String[result.size()]);
    }

    public static String[] removeDuplicateName(String[] carNames){
        return new HashSet<>(Arrays.asList(carNames)).toArray(new String[0]);
    }

    public static boolean isUnderMaxSpellings(String[] inputStrArray, int maxLength) {
        for(int i = 0; i < inputStrArray.length; i++){
            if(inputStrArray[i].length() > maxLength){
                return false;
            }
        }
        return true;
    }

}
