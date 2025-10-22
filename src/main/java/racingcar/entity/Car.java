package racingcar.entity;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;
    private int position;

    public Car(String carName) {
        this.name = carName;
        this.position = 0;
    }

    private Car(String carName, int position) {
        throw new RuntimeException("초기 위치는 초기화 할 수 없습니다!");
    }

    private Car(){
        throw new RuntimeException("기본생성자는 생성 할 수 없습니다!");
    }

    public void move() {
        if( Randoms.pickNumberInRange(0, 9)>=4){
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
