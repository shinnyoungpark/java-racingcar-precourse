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
        int moveNum = getNumberOfMovements();

    }

    private int getNumberOfMovements() {
        int moveNum = -1;

        while (true){
            System.out.println("0부터 9사이의 값을 입력하세요.");

            if(!scanner.hasNextInt()){
                scanner.next();
                System.out.println("숫자가 아닙니다.");
                continue;
            }

            moveNum = scanner.nextInt();
            if(isOneDigit(moveNum)){
                return moveNum;
            }
        }
    }

    private boolean isOneDigit(int moveNum) {
        if(moveNum >= 0 && moveNum < 10){
            return true;
        }
        return false;
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
