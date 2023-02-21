package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RewardsTest {
    @DisplayName("보상의 입력 개수는 사다리 게임 참가자 수와 동일하다.")
    @ParameterizedTest
    @CsvSource(value = {"a,b:A,B", "a,b,c:A,B,C", "a,b,c,d,e:A,B,C,D,E"}, delimiter = ':')
    void validRewardsTest(String names, String rewards) {
        assertDoesNotThrow(() -> new Rewards(rewards, new Names(names)));
    }

    @DisplayName("보상의 입력 개수와 사다리 게임 참가자 수가 다르면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"a,b:A,B,C", "a,b,c:A,B", "a,b,c,d,e:A,B,C,D"}, delimiter = ':')
    void invalidRewardsTest(String names, String rewards) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Rewards(rewards, new Names(names)))
                .withMessageContaining("[ERROR] 보상의 개수는 사용자의 수와 동일해야 합니다.");
    }
}
