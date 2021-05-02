package com.wootechcamp.precourse.racingcar;

import java.util.*;

public class RacingCarGame {

    private static final int GO_BASE_NUMBER = 4;

    private Scanner scanner;
    private List<Car> carList;

    RacingCarGame(){
        scanner = new Scanner(System.in);
        carList = new ArrayList<>();
    }
    public void start(){
        System.out.println("Game start!");

        String[] carNames = getCarName();

        int moveNum = getNumberOfMovements();

        setCarList(carNames);

        startRace(moveNum);

        getWinner();


        System.out.println("total score :");
        for(Car c : carList){
            System.out.println(c.getName() + " : " + c.getPosition());
        }
    }

    private void getWinner() {
        Collections.sort(carList);

        int highestScore = carList.get(0).getPosition();

        List<String> winners = new ArrayList<>();
        for(Car c : carList){
            if(c.getPosition() == highestScore){
                winners.add(c.getName());
            }
        }

        printWinner(winners);
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
        for(int i = 0; i < moveNum; i++){
            System.out.println("moveNum :"+i);
            goOneStep();
        }
    }

    private void goOneStep(){
        for(int i = 0; i < carList.size(); i++){
            int randomNum = getRandomNumber();
            System.out.println("random :"+randomNum);

            if(randomNum >= GO_BASE_NUMBER){
                Car car = carList.get(i);
                car.go();
            }
        }

        carList.stream().forEach(car -> {
            System.out.println(car.getName() + ":"+getStringBar(car.getPosition()));
        });
    }

    private String getStringBar(int position){
        String result = "";
        for(int i = 0; i < position; i++){
            result = result + "-";
        }

        return result;
    }

    private int getRandomNumber(){
        Random random = new Random();
        return random.nextInt(10);
    }

    private void setCarList(String[] carNames) {
        for(int i = 0; i < carNames.length; i++){
            Car car = new Car();
            car.setPosition(0);
            car.setName(carNames[i]);
            carList.add(car);
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
