package sudoku.board;

import sudoku.domain.Row;

import java.util.Arrays;
import java.util.List;

public class StandardBoard {

    private final List<Row> rows;

    /**
     * Sudoku board is constructed with 9 rows, each containing 9 cells.
     */
    StandardBoard(List<Row> rows) {

        if (rows.size() != 9) {
            throw new IllegalArgumentException("Exactly nine rows expected");
        }
        this.rows = rows;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(createHorizonalSeparator()).append("\n");

        for (int i = 1; i <= rows.size(); i++) {

            Row row = rows.get(i-1);

            sb.append("|").append(row.toString("|")).append("\n");

            if (i % 3 == 0) {
                sb.append(createHorizonalSeparator()).append("\n");
            }
        }

        return sb.toString();
    }

    private String createHorizonalSeparator() {
        char[] chars = new char[19];
        Arrays.fill(chars, '-');
        return new String(chars);
    }

    public static StandardBoardBuilder builder() {
        return new StandardBoardBuilder();
    }
}
