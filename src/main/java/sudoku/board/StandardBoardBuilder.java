package sudoku.board;

import sudoku.domain.Cell;
import sudoku.domain.StandardCell;

import java.util.ArrayList;
import java.util.List;

public class StandardBoardBuilder {


    private List<List<Cell>> rows = new ArrayList<>();

    public StandardBoardBuilder withRow(String rowAsString) {
        String[] numbers = rowAsString.split("|,");

        List<Cell> row = buildRow(numbers);

        rows.add(row);

        return this;
    }

    private List<Cell> buildRow(String[] numbers) {
        List<Cell> cells = new ArrayList<>();
        for (String number : numbers) {

            if (Character.isDigit(number.charAt(0))) {
                Cell cell = new StandardCell();

                if (!"0".equals(number)) {
                    cell.solve(Integer.parseInt(number));
                }

                cells.add(cell);
            }
        }
        return cells;
    }

    public StandardBoard build() {
        return new StandardBoard(rows);
    }
}
