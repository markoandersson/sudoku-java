package sudoku.board;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StandardBoardBuilder {


    private List<String[]> rows = new ArrayList<>();

    public StandardBoardBuilder withRow(String rowAsString) {
        String[] numbers = rowAsString.split("|,");

        String[] onlyNumbers = Stream.of(numbers)
                .filter(s -> Character.isDigit(s.charAt(0))).toArray(String[]::new);

        rows.add(onlyNumbers);

        return this;
    }

    public Board build() {
        return new StandardBoard(rows.toArray(new String[0][0]));
    }
}
