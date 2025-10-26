package racingcar.service;

import racingcar.entity.Car;

import java.util.List;
import java.util.Queue;

public interface RaceService {

    /**
     *
     * @param carsName 차 이름들이 적힌 문자열
     * 입력값을 검증 후
     * 중복된 차이름이 있는지 검증합니다.
     * 이상이 없다면
     * 자동차 객체를 만들어줍니다.
     */
    void createCars(String carsName);


    /**
     * 한번씩 차들 움직이게 한 후
     * @return 모든 차를 리스트로 반환
     */
    List<Car> doOneRace();

    /**
     * 이동 횟수를 비교하여 우승자를
     * @return 우승자(들) 이름 받아오기
     */
    Queue<String> getWinners();

}
