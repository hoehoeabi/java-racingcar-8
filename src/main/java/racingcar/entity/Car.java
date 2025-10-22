package racingcar.entity;

import racingcar.strategy.MovementStrategy;

public class Car {

    private String name;
    private int position;
    private final MovementStrategy movementStrategy;

    public Car(String carName, MovementStrategy movementStrategy) {
        this.name = carName;
        this.position = 0;
        this.movementStrategy = movementStrategy;
    }

    private Car(String carName, int position) {
        throw new RuntimeException("초기 위치는 초기화 할 수 없습니다!");
    }

    private Car(){
        throw new RuntimeException("기본생성자는 생성 할 수 없습니다!");
    }

    public void move() {
        if (movementStrategy.canMove()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
