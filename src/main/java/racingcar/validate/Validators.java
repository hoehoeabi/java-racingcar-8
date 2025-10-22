package racingcar.validate;


public interface Validators {

    /**
     *
     * @param carNames 입력받은 차이름들이 적힌 문자열
     *
     * 1. 차이름이 무조건 하나 + (,차이름)패턴이 0회 이상 반복되는지 검증
     * 2. 차이름이 하나일경우 검증
     *                 -> (차이름,){min,1}차이름{1}로도 할까 했는데
     *                 예외를 세세히 나누고자 1번처럼 정규식을 짰습니다.
     */
    void inputValidate(String carNames);

    /**
     *
     * @param raceReps 입력받은 경기 횟수
     *
     * 1. Number(Integer)으로 형변환 되는지 검증
     * 2. 시도회수는 최대 5회로 검증
     * 3. 시도회수는 음수이면 안됨
     */
    void repsValidate(String raceReps);
}
