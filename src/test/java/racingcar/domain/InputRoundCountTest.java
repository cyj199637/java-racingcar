package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.input.InputRoundCount;
import racingcar.domain.input.RoundCount;
import racingcar.domain.input.exception.InvalidNumberException;
import racingcar.domain.input.exception.OnlyPositiveException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputRoundCountTest {

    @Test
    @DisplayName("숫자 외 다른 값으로 생성할 경우 InvalidNumberException.class 예외(메시지 '숫자만 입력이 가능합니다.')를 반환한다.")
    void catTest() {
        assertThatThrownBy(() -> new InputRoundCount("string"))
                .isInstanceOf(InvalidNumberException.class)
                .hasMessage("숫자만 입력이 가능합니다.");
    }

    @Test
    @DisplayName("음수 문자열값으로 생성할 경우 OnlyPositiveException 에외(메시지 '1 이상의 값만 가능합니다.')를 반환한다.")
    void InputNumberOnlyPositive() {
        assertThatThrownBy(() -> new InputRoundCount("-1"))
                .isInstanceOf(OnlyPositiveException.class)
                .hasMessage("1 이상의 값만 가능합니다.");
    }

    @Test
    @DisplayName("0 값으로 생성할 경우 OnlyPositiveException 에외(메시지 '1 이상의 값만 가능합니다.')를 반환한다.")
    void InputNumberNotZero() {
        assertThatThrownBy(() -> new InputRoundCount("0"))
                .isInstanceOf(OnlyPositiveException.class)
                .hasMessage("1 이상의 값만 가능합니다.");
    }

    @Test
    @DisplayName("문자열 숫자를 입력하면 문자열 숫자가 최종 라운드인 Round가 반환된다.")
    void StringToInt() {
        RoundCount roundTwo = new RoundCount(2);
        assertThat(new InputRoundCount("2").toRound()).isEqualTo(new Round(roundTwo));
    }
}