package racingcar.service;

import racingcar.entity.Car;

import java.util.List;
import java.util.Queue;

public interface RaceService {

    /**
     *
     * @param carsName 차 이름들이 적힌 문자열
     *
     * @implSpec
     * validators를 사용하여 입력값을 검증합니다.
     * 검증도중에 예외가 던져지지 않았다면
     * 자동차 객체를 만들어줍니다.
     */
    void createCars(String carsName);


    /**
     *
     * @implSpec
     * 한번씩 차들 움직이게 한 후
     * @return 모든 차를 리스트로 반환해줍니다.
     *
     */
    List<Car> doOneRace();

    /**
     * @implSpec
     * 이동 횟수를 비교하여 가장 많이 움직인 횟수를 알아낸 후
     * 해당 이동횟수와 동일하게 움직인 차 객체들에게서 이름을 가져옵니다.
     * @return 우승자(들) 이름을 반환해줍니다.
     */
    Queue<String> getWinners();

}
