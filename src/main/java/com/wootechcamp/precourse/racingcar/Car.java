package com.wootechcamp.precourse.racingcar;

public class Car implements Comparable<Car> {

    private String name;
    private int position;

    public Car(String name){
        this.position = 0;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(){
        position = position + 1;
    }

    @Override
    public int compareTo(Car c) {
        if(this.position < c.getPosition()){
            return 1;
        } else if (this.position > c.getPosition()) {
            return -1;
        }
        return 0;
    }

}
