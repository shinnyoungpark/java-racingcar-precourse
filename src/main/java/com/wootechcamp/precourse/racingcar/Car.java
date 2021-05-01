package com.wootechcamp.precourse.racingcar;

public class Car {

    private String name;
    private int position;

    Car(){
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

    public void go(){
        position = position + 1;
    }

}
