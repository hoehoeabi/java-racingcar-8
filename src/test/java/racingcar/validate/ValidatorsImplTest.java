package racingcar.validate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.validate.pattern.GameRules.*;

class ValidatorsImplTest {

    private ValidatorsImpl validators;

    @BeforeEach
    void setup(){
         this.validators = new ValidatorsImpl(
                ONLY_ONE_CAR_PATTERN,  // GameRules.ONLY_ONE_CAR_PATTERN
                RACING_CARS_PATTERN,   // GameRules.RACING_CARS_PATTERN
                MAX_RACE_REPETITION    // GameRules.MAX_RACE_REPETITION
        );
    }

    @Test
    @DisplayName("제대로 된 입력값")
    void inputValidate_성공() {
        // given
        String input = "pobi, babi";

        // when & then
        assertDoesNotThrow(() -> validators.inputValidate(input));
    }

    @Test
    @DisplayName("차가 오직 한대")
    void inputValidate_차가한대_실패() {
        // given
        String input = "pobi";

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validators.inputValidate(input);
        });

        assertThat(exception.getMessage()).isEqualTo("자동차 한개로는 경기를 시작하지 못합니다!");
    }

    // 에러로그 보면 어떤 케이스가 실패했는지 확인 가능해서 한곳에서 테스트 했습니다.
    @Test
    @DisplayName("입력값이 정규식에 맞지 않게 들어옴. 변수 생성 방식")
    void inputValidate_입력값_정규식검증_실패() {
        // given
        String exceptionMessage = "제대로 된 입력값을 주세요!" +
                "\n자동차이름은 최대 5자이며" +
                "\n자동차는 알파벳 대소문자로 최대 5대까지 입력 가능합니다!";
        String input1 = "pobi,";
        String input2 = "pobi,asd!";
        String input3 = "ㅁ";

        // when & then
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> {
            validators.inputValidate(input1);
        });
        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> {
            validators.inputValidate(input2);
        });
        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class, () -> {
            validators.inputValidate(input3);
        });

        assertThat(exception1.getMessage()).isEqualTo(exceptionMessage);
        assertThat(exception2.getMessage()).isEqualTo(exceptionMessage);
        assertThat(exception3.getMessage()).isEqualTo(exceptionMessage);
    }

    // 공부를 해보니 CsvSource는 두 값을 비교하는데에 적합한 인수테스트라고 생각됩니다.
    // 공부 기록용으로 남겨두겠습니다.
    @ParameterizedTest
    @DisplayName("입력값이 정규식에 맞지 않게 들어옴. CsvSource 방식")
    @CsvSource(value = {"'pobi,'","'pobi,asd!'","ㅁ"})
    void inputValidate_입력값_정규식검증_실패_CsvSource사용(String input) {
        // given
        String exceptionMessage = "제대로 된 입력값을 주세요!" +
                "\n자동차이름은 최대 5자이며" +
                "\n자동차는 알파벳 대소문자로 최대 5대까지 입력 가능합니다!";

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validators.inputValidate(input);
        });
        assertThat(exception.getMessage()).isEqualTo(exceptionMessage);
    }

    @ParameterizedTest
    @DisplayName("입력값이 정규식에 맞지 않게 들어옴. ValueSource방식")
    @ValueSource(strings = {"pobi,","pobi,asd!","ㅁ"})
    void inputValidate_입력값_정규식검증_실패_ValueSource사용(String input) {
        // given
        String exceptionMessage = "제대로 된 입력값을 주세요!" +
                "\n자동차이름은 최대 5자이며" +
                "\n자동차는 알파벳 대소문자로 최대 5대까지 입력 가능합니다!";

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validators.inputValidate(input);
        });
        assertThat(exception.getMessage()).isEqualTo(exceptionMessage);
    }

    @Test
    @Disabled("중복 이름 체크는 통합테스트로 대체")
    void nameDuplicateValidate_성공() {
    }

    @Test
    void repsValidate_성공() {
        // given
        String input = "5";

        // when & then
        assertDoesNotThrow(() -> validators.repsValidate(input));
    }

    // 에러로그 보면 어떤 케이스가 실패했는지 확인 가능해서 한곳에서 테스트 했습니다.
    @Test
    @DisplayName("0 입력,문자입력,최대횟수5회 초과")
    void repsValidate_실패() {
        // given
        String input1 = "0";
        String input2 = "문자입력";
        String input3 = "6";

        // when
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> {
            validators.repsValidate(input1);
        });
        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> {
            validators.repsValidate(input2);
        });
        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class, () -> {
            validators.repsValidate(input3);
        });

        // then
        assertThat(exception1.getMessage()).isEqualTo("시도 횟수는 1 이상이어야 합니다.");
        assertThat(exception2.getMessage()).isEqualTo("시도 횟수는 숫자만 입력 가능합니다!");
        assertThat(exception3.getMessage()).isEqualTo("시도 횟수는 최대 5회까지입니다!");
    }
}