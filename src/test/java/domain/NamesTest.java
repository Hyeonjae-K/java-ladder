package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NamesTest {
    @DisplayName("사람의 수는 2명 이상 100명 이하이다.")
    @ParameterizedTest
    @ValueSource(strings = {"깃짱,제리,이리내,제나", "깃짱,제리"})
    void validNamesTest(String names) {
        Assertions.assertDoesNotThrow(() -> new Names(names));
    }

    @DisplayName("사람의 수가 2명 미만인 경우 예외 처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"깃짱", "제리"})
    void underflowNamesTest(String names) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Names(names))
                .withMessageContainingAll("[ERROR]", "이하의 사람 수를 입력해 주세요.");
    }

    @DisplayName("사람의 수가 100명 초과인 경우 예외처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"깃짱,", "제리,"})
    void overflowNamesTest(String names) {
        int repeatCount = 101;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Names(names.repeat(repeatCount)))
                .withMessageContainingAll("[ERROR]", "이하의 사람 수를 입력해 주세요.");
    }

    @DisplayName("중복된 이름이 있으면 예외처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a,a", "a,b,c,c"})
    void duplicationNameTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Names(input))
                .withMessageContaining("중복된 이름은 입력할 수 없습니다.");
    }
}
