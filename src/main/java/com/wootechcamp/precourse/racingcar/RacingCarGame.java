package com.wootechcamp.precourse.racingcar;

import java.util.*;

public class RacingCarGame {

    private static final int MOVE_BASE_NUMBER = 4;

    private Cars cars;
    private Scanner scanner;

    RacingCarGame() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Game start!");

        CarNames carNames = getCarName();

        int moveNum = getNumberOfMovements();

        cars = new Cars(carNames);

        startRace(moveNum);

        List<String> winners = cars.getWinners();

        printWinners(winners);

    }

    private void printWinners(List<String> winners) {
        System.out.print(winners.get(0));

        if (winners.size() > 1) {
            for (int i = 1; i < winners.size(); i++) {
                System.out.print(", " + winners.get(i));
            }
        }

        System.out.println("가 최종 우승했습니다.");
    }

    private void startRace(int moveNum) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < moveNum; i++) {
            cars.moveOnce(MOVE_BASE_NUMBER);
            System.out.println();
        }
    }

    private int getNumberOfMovements() {
        int moveNum = -1;

        while (true) {
            System.out.println("0부터 9사이의 값을 입력하세요.");

            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("숫자가 아닙니다.");
                continue;
            }

            moveNum = scanner.nextInt();
            if (isOneDigit(moveNum)) {
                return moveNum;
            }
        }
    }

    private boolean isOneDigit(int moveNum) {
        if (moveNum >= 0 && moveNum < 10) {
            return true;
        }
        return false;
    }

    private CarNames getCarName() {
        CarNames carNames;
        System.out.println("차이름을 입력해주세요.");
        while (true) {
            try {
                String input = scanner.next();
                carNames = new CarNames(input);

                return carNames;

            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
    }

}
