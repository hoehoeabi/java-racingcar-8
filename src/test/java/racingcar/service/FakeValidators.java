package racingcar.service;

import racingcar.validate.Validators;

// Validators 인터페이스를 구현하는 "테스트용" 클래스
class FakeValidators implements Validators {

    @Override
    public void inputValidate(String input) {

    }

    @Override
    public void nameDuplicateValidate(int listSize, int setSize) {

    }

    @Override
    public void repsValidate(String raceReps) {

    }
}
