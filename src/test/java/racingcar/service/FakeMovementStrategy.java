package racingcar.service;

import racingcar.strategy.MovementStrategy;

// 테스트를 위해 "항상 움직이거나" "항상 멈추도록" 제어하는 가짜 전략
class FakeMovementStrategy implements MovementStrategy {

    private final boolean alwaysMove;

    public FakeMovementStrategy(boolean alwaysMove) {
        this.alwaysMove = alwaysMove;
    }

    @Override
    public boolean canMove() {
        return alwaysMove;
    }
}
