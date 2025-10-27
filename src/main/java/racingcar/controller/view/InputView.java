package racingcar.controller.view;

public interface InputView {

    /**
     * @implSpec
     * 자동차 이름들을 문자열로 입력 받습니다.
     *
     * @return 경기에 참여할 자동차 이름들 문자열
     */
    String carsNameInputView();

    /**
     * @implSpec
     * 사용자로부터 경기 횟수를 입력받습니다.
     *
     * @return 경기 횟수 문자열
     */
    String raceRepetitionInputView();

}
