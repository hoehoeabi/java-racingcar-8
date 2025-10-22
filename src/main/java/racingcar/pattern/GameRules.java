package racingcar.pattern;

import java.util.regex.Pattern;

public class GameRules {

    private static final String ONLY_ONE_CAR_REGEX = "^([a-zA-Z]{1,5}){1}$";
    private static final String RACING_CARS_REGEX = "^\\s*([a-zA-Z]{1,5})(\\s*,\\s*[a-zA-Z]{1,5}){0,4}\\s*$";

    public static final Pattern ONLY_ONE_CAR_PATTERN = Pattern.compile(ONLY_ONE_CAR_REGEX);
    public static final Pattern RACING_CARS_PATTERN = Pattern.compile(RACING_CARS_REGEX);

    public static final Integer MAX_RACE_REPETITION = 5;

    // 유틸리티 클래스이므로 인스턴스화 방지
    private GameRules() {
        throw new IllegalStateException("Rules class");
    }

}
