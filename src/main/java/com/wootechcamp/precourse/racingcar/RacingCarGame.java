package com.wootechcamp.precourse.racingcar;

import java.util.Scanner;

public class RacingCarGame {

    private Scanner scanner;

    RacingCarGame(){
        scanner = new Scanner(System.in);
    }
    public void start(){
        System.out.println("Game start!");
        String[] carNames = getCarName();

        for(int i = 0; i < carNames.length; i++){
            System.out.println(carNames[i]);
        }
    }

    private String[] getCarName(){
        String[] carNames;
        System.out.println("차이름을 입력해주세요.");
        while(true){
            String input = scanner.next();

            if(!input.contains(",")){
                System.out.println("자동차 구분자는 ,(쉼표)로 해주세요.");
                continue;
            }

            carNames = input.split(",");
            if(!isUnderFiveSpellings(carNames)){
                System.out.println("자동차 이름은 5자 이하로 입력해 주세요.");
                continue;
            }

            return carNames;
        }
    }

    private boolean isUnderFiveSpellings(String[] inputStrArray) {
        for(int i = 0; i < inputStrArray.length; i++){
            if(inputStrArray[i].length() > 5){
                return false;
            }
        }
        return true;
    }

}
