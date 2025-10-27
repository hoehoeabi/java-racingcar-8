package racingcar.validate;


import java.util.List;

public interface Validators {

    /**
     *
     * @param carNames 입력받은 차이름들이 적힌 문자열
     *
     * @implSpec
     * 1. 차이름이 무조건 하나 + (,차이름)패턴이 0회 이상 반복되는지 검증
     * 2. 차이름이 하나일경우 검증
     *                 -> (차이름,){min,1}차이름{1}로도 할까 했는데
     *                 예외를 세세히 나누고자 1번처럼 정규식을 짰습니다.
     * 조건에 맞지 않다면 예외를 던져 main에서 잡고 어플리케이션이 종료됩니다.
     */
    void inputValidate(String carNames);

    /**
     *
     * @param carNames 차이름 리스트
     *
     * @implSpec
     * 차이름은 중복 X
     * 리스트의 요소들을 Set으로 만든 후 기존 List와 Set사이의 크기를 비교합니다.
     * 크기가 다르다면 예외를 던져 main에서 잡고 어플리케이션이 종료됩니다.
     */
    void nameDuplicateValidate(List<String> carNames);

    /**
     *
     * @param raceReps 입력받은 경기 횟수
     *
     * @implSpec
     * 1. Number(Integer)으로 형변환 되는지 검증
     * 2. 시도회수는 최대 5회로 검증
     * 3. 시도회수는 음수이면 안됨
     * 조건에 맞지 않다면 예외를 던져 main에서 잡고 어플리케이션이 종료됩니다.
     */
    void repsValidate(String raceReps);

}
