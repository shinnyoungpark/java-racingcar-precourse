package com.wootechcamp.precourse.racingcar.model;

import com.wootechcamp.precourse.racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private static final String MOVEMENT_MARK = "-";

    private List<Car> carList;

    public Cars(String[] carNames){
        carList = new ArrayList<>();
        for(int i = 0; i < carNames.length; i++){
            Car car = new Car(carNames[i]);
            carList.add(car);
        }
    }

    public List<String> getWinners() {
        Collections.sort(carList);

        int highestScore = carList.get(0).getPosition();

        List<String> winners = new ArrayList<>();
        for(Car c : carList){
            if(c.getPosition() == highestScore){
                winners.add(c.getName());
            }
        }
        return winners;
    }

    public void moveOnce(int moveBaseNumber){
        for(Car car : carList){
            int randomNum = RandomNumberGenerator.getRandomNumber();

            if(randomNum >= moveBaseNumber){
                car.move();
            }
        }

        printCars();
    }

    private String getStringBar(int position){
        String result = "";
        for(int i = 0; i < position; i++){
            result = result + MOVEMENT_MARK;
        }

        return result;
    }

    public void printCars(){
        for(Car car : carList){
            System.out.println(car.getName() + " : " + getStringBar(car.getPosition()));
        }
    }
}
