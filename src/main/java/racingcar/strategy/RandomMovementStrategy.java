package racingcar.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementStrategy implements MovementStrategy {
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD;
    }
}