package racingcar.controller.view;

import racingcar.entity.Car;

import java.util.List;
import java.util.Queue;

public interface RaceView {

    // =================== InputView ===================
    /**
     *
     * @return 경기에 참여할 자동차 이름들 문자열
     */
    String carsNameInputView();

    /**
     *
     * @return 경기 횟수 문자열
     */
    String raceRepetitionInputView();

    // =================== OutputView ===================

    /**
     *  "실행 결과" 단 하나만을 띄울 뷰 ㅋㅋ
     */
    void outcomeTopView();

    /**
     *
     * @param cars 자동채 객체가 담긴 리스트
     * 자동차 리스트를 받아서 경기 진행상황을 띄울 뷰
     */
    void raceFlowResultView(List<Car> cars);

    /**
     * @param winners 우승자 이름들이 담긴 리스트
     * 이름을 받고 출력해주는 뷰
     */
    void showWinnerOutputView(Queue<String> winners);

}