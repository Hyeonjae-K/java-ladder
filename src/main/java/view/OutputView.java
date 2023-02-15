package view;

import domain.Line;
import domain.Lines;
import domain.Names;

public class OutputView {

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public void printResult(Names names, Lines lines) {
        System.out.println(Message.OUTPUT_RESULT.message);
        names.getNames()
                .forEach(name -> System.out.printf("%-5s", name.getName()));
        System.out.println();
        Lines(lines);
    }

    public void Lines(Lines lines) {
        for (Line line : lines.getLines()) {
            StringBuilder result = new StringBuilder();
            result.append(Message.COLUMN_LADDER.message);
            line.getPoints()
                    .forEach(isPoint -> result.append(getPointString(isPoint)));
            System.out.println(result);
        }
    }

    private String getPointString(boolean isPoint) {
        if (isPoint) {
            return Message.ROW_LADDER.message;
        }
        return Message.EMPTY_ROW_LADDER.message;
    }

    private enum Message {
        OUTPUT_RESULT("실행결과\n"),
        COLUMN_LADDER("  |"),
        ROW_LADDER("-----|"),
        EMPTY_ROW_LADDER("     |");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}