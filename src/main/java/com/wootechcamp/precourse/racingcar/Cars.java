package com.wootechcamp.precourse.racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cars {

    private static final int GO_BASE_NUMBER = 4;

    private List<Car> carList;

    Cars(){
        carList = new ArrayList<>();
    }

    public void getWinner() {
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

    public void goOneStep(){
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

    private void printWinner(List<String> winners) {
        System.out.print(winners.get(0));

        if(winners.size() > 1){
            for(int i = 1; i < winners.size(); i++){
                System.out.print(", " + winners.get(i));
            }
        }

        System.out.println("가 최종 우승했습니다.");
    }


    public void printCars(){
        for(Car c : carList){
            System.out.println(c.getName() + " : " + c.getPosition());
        }
    }

    public void setCarList(String[] carNames) {
        for(int i = 0; i < carNames.length; i++){
            Car car = new Car();
            car.setPosition(0);
            car.setName(carNames[i]);
            carList.add(car);
        }
    }
}
