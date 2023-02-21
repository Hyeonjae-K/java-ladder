package domain;

import java.util.ArrayList;
import java.util.List;
import utils.BooleanGenerator;

public class Line {
    private final BooleanGenerator generator;
    private final List<Boolean> line = new ArrayList<>();

    public Line(int lineSize, BooleanGenerator generator) {
        this.generator = generator;
        generateLine(lineSize);
    }

    public List<Boolean> getLine() {
        return List.copyOf(line);
    }

    public int getLineSize() {
        return line.size();
    }

    private void generateLine(int lineSize) {
        for (int index = 0; index < lineSize; index++) {
            line.add(getPoint(index));
        }
    }

    private boolean getPoint(int index) {
        if (isBeforePointTrue(index)) {
            return false;
        }
        return generator.generate();
    }

    private boolean isBeforePointTrue(int index) {
        return index > 0 && line.get(index - 1);
    }
}
