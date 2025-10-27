package racingcar.controller.view;

import racingcar.entity.Car;

import java.util.List;
import java.util.Queue;

public interface OutPutView {

    /**
     * @implSpec
     * 요구사항에 맞게 "실행 결과" 를 보여줍니다.
     */
    void outcomeTopView();

    /**
     *
     * @param cars 자동채 객체가 담긴 리스트
     *
     * @implSpec
     * 자동차 리스트를 받아서 이름과 이동 횟수를 요구사항과 같은 양식으로 화면에 띄어줍니다.
     */
    void raceFlowResultView(List<Car> cars);

    /**
     * @param winners 우승자 이름들이 담긴 리스트
     *
     * @implSpec
     * 우승자들의 이름을 받은 후 요구사항과 같은 양식으로 이름들을 보여줍니다.
     */
    void showWinnerOutputView(Queue<String> winners);

}