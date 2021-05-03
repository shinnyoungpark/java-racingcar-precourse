package com.wootechcamp.precourse.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    Cars cars = new Cars();

    @Test
    @DisplayName("10미만 랜덤 발생 함수 검사")
    public void getRandomNumber(){
        try {
            Set<Integer> numbers = new HashSet<>();
            for(int i = 0; i < 10; i++){
                numbers.add(i);
            }
            Method method = cars.getClass().getDeclaredMethod("getRandomNumber");
            method.setAccessible(true);
            int random = (int) method.invoke(cars);

            assertThat(numbers.contains(random)).isTrue();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Test
    @DisplayName("winners 거르기")
    public void getWinners(){
        try {
            List<Car> input = new ArrayList<>();
            Car carA = new Car();
            carA.setName("a");
            carA.setPosition(5);

            Car carB = new Car();
            carB.setName("b");
            carB.setPosition(0);

            Car carC = new Car();
            carC.setName("c");
            carC.setPosition(8);

            input.add(carA);
            input.add(carB);
            input.add(carC);

            Field field = cars.getClass().getDeclaredField("carList");
            field.setAccessible(true);

            field.set(cars, input);
            List<Car> carList = (ArrayList<Car>) field.get(cars);

            for(Car c : carList)
                System.out.println(c.getName() + ":" + c.getPosition());

            List<String> winners = cars.getWinners();


            for(String c : winners)
                System.out.println(c);

            List<String> result = new ArrayList<>();
            result.add("c");
           // result.add("a");

            assertThat(winners.containsAll(result)).isTrue();

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
