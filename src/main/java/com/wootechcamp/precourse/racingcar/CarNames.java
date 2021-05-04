package com.wootechcamp.precourse.racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CarNames {

    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final String DELIMITER = ",";

    private String[] carNames;

    public CarNames(String input) {

        if (!input.contains(DELIMITER)) {
            System.out.println("자동차 구분자는 " + DELIMITER + " 로 해주세요.");
            throw new IllegalArgumentException("자동차 구분자는 " + DELIMITER + " 로 해주세요.");
        }

        String[] inputStrArray = input.split(DELIMITER);

        for (int i = 0; i < inputStrArray.length; i++) {
            if (inputStrArray[i].length() > CAR_NAME_MAX_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 " + CAR_NAME_MAX_LENGTH + "자 이하로 입력해 주세요.");
            }
        }

        this.carNames = inputStrArray;
        this.carNames = removeEmptyString();
        this.carNames = removeDuplicateName();
    }

    private String[] removeEmptyString() {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < this.carNames.length; i++) {
            if (this.carNames[i] != null && this.carNames[i].length() > 0) {
                result.add(this.carNames[i]);
            }
        }

        return result.toArray(new String[result.size()]);
    }

    private String[] removeDuplicateName() {
        return new HashSet<>(Arrays.asList(this.carNames)).toArray(new String[0]);
    }

    public String[] getCarNames() {
        return carNames;
    }
}
