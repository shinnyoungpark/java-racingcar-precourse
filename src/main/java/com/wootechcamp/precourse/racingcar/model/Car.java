package com.wootechcamp.precourse.racingcar.model;

public class Car implements Comparable<Car> {

    private String name;
    private int position;

    public Car(){
        position = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
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
