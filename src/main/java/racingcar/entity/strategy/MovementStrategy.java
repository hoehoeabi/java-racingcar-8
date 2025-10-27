package racingcar.entity.strategy;

public interface MovementStrategy {
    /**
     * @implSpec
     * 움직일 수 있으면 true, 아니면 false를 반환합니다.
     * @return boolean
     */
    boolean canMove();
}
