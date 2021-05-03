package com.wootechcamp.precourse.racingcar;

import java.util.*;

public class RacingCarGame {

    private static final int MOVE_BASE_NUMBER = 4;
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private Cars cars;
    private Scanner scanner;

    RacingCarGame(){
        scanner = new Scanner(System.in);
        cars = new Cars();
    }

    public void start(){
        System.out.println("Game start!");

        String[] carNames = getCarName();

        int moveNum = getNumberOfMovements();

        cars.setCarList(carNames);

        startRace(moveNum);

        List<String> winners = cars.getWinners();

        printWinner(winners);

        //System.out.println("total score :");
        //cars.printCars();
    }

    private void printWinner(List<String> winners) {
        System.out.print(winners.get(0));

        if(winners.size() > 1){
            for(int i = 1; i < winners.size(); i++){
                System.out.print(", " + winners.get(i));
            }
        }

        System.out.println("가 최종 우승했습니다.");
    }

    private void startRace(int moveNum){
        System.out.println("\n실행 결과");
        for(int i = 0; i < moveNum; i++){
            cars.moveOnce(MOVE_BASE_NUMBER);
            System.out.println();
        }
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

            carNames = removeEmptyString(carNames);

            carNames = removeDuplicateName(carNames);

            return carNames;
        }
    }

    private String[] removeEmptyString(String[] carNames) {
        List<String> result = new ArrayList<>();

        for(int i = 0; i < carNames.length; i++){
            if(carNames[i] != null && carNames[i].length() > 0){
                result.add(carNames[i]);
            }
        }

        return result.toArray(new String[result.size()]);
    }

    private String[] removeDuplicateName(String[] carNames){
        return new HashSet<>(Arrays.asList(carNames)).toArray(new String[0]);
    }

    private boolean isUnderFiveSpellings(String[] inputStrArray) {
        for(int i = 0; i < inputStrArray.length; i++){
            if(inputStrArray[i].length() > CAR_NAME_MAX_LENGTH){
                return false;
            }
        }
        return true;
    }

}
