package com.wootechcamp.precourse.racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cars {

    private List<Car> carList;

    Cars(){
        carList = new ArrayList<>();
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

    public void moveOnce(int goBaseNumber){
        for(Car car : carList){
            int randomNum = getRandomNumber();
            //System.out.println("random :"+randomNum);

            if(randomNum >= goBaseNumber){
                car.move();
            }
        }

        printCars();
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

    public void printCars(){
        for(Car car : carList){
            System.out.println(car.getName() + " : " + getStringBar(car.getPosition()));
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
