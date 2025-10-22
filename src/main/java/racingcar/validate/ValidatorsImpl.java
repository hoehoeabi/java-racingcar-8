package racingcar.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorsImpl implements Validators {

    private final Pattern onlyOneInputPattern;
    private final Pattern inputPattern;
    private final Integer MAX_RACE_REPETITION;

    public ValidatorsImpl(Pattern onlyOneInputPattern
            , Pattern inputPattern
            , Integer MAX_RACE_REPETITION) {
        this.onlyOneInputPattern = onlyOneInputPattern;
        this.inputPattern = inputPattern;
        this.MAX_RACE_REPETITION = MAX_RACE_REPETITION;
    }

    @Override
    public void inputValidate(String carNames) {
        Matcher onlyOneInputMatcher = onlyOneInputPattern.matcher(carNames);
        Matcher inputPatternMatcher = inputPattern.matcher(carNames);
        if(onlyOneInputMatcher.matches()){
            throw new IllegalArgumentException("자동차 한개로는 경기를 시작하지 못합니다!");
        }
        if(!inputPatternMatcher.matches()){
            throw new IllegalArgumentException("제대로 된 입력값을 주세요!" +
                    "\n자동차이름은 최대 5자이며" +
                    "\n자동차는 최대 5대까지 입력 가능합니다!");
        }
    }

    @Override
    public void repsValidate(String raceReps) {
        int reps;
        try {
            reps = Integer.parseInt(raceReps);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다!");
        }

        int maxReps = MAX_RACE_REPETITION;

        if (reps > maxReps) {
            throw new IllegalArgumentException("시도 횟수는 최대 " + maxReps + "회까지입니다!");
        }

        if (reps <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
