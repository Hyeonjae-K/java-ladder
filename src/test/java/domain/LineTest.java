package domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import utils.TrueBooleanGenerator;

class LineTest {
    private final TrueBooleanGenerator trueBooleanGenerator = new TrueBooleanGenerator();

    @Nested
    class pointsTest {
        @DisplayName("연속적으로 true가 발생해도 사다리는 정상적으로 생성된다.")
        @Test
        void trueSequenceTest() {
            Names names = new Names("a,b,c,d");
            LineSize lineSize = new LineSize(names);
            assertDoesNotThrow(() -> new Line(lineSize, trueBooleanGenerator));
        }
    }
}
